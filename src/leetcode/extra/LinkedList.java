package leetcode.extra;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * LinkedList实际上是通过双向链表去实现的、整个链表是同过Entry实体类来存储数据的
 */

public class LinkedList<E> extends AbstractSequentialList<E>
		implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
	// 链表的表头、表头不包含任何数据、
	// Entry是双向链表节点所对应的数据结构，它包括的属性有：当前节点所包含的值，上一个节点，下一个节点。
	private transient Entry<E> header = new Entry<E>(null, null, null);

	// LinkedList中元素个数
	private transient int size = 0;

	/**
	 * 构造一个空的LinkedList、只含有表头
	 */
	public LinkedList() {
		header.next = header.previous = header;
	}

	/**
	 * 创建一个包含c的LinkedList、先创建默认空、然后将c中所有元素添加到LinkedList中
	 */
	public LinkedList(Collection<? extends E> c) {
		this();
		addAll(c);
	}

	/** 获取链表第一个元素、 */
	public E getFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		// 因其是双向链表、这里的header可视为顺序的第一个不含元素的表头、所以第一个是此header的下一个元素
		return header.next.element;
	}

	/** 获取链表最后一个元素 */
	public E getLast() {
		if (size == 0)
			throw new NoSuchElementException();
		// 因其是双向链表、这里的header可视为逆序的第一个不含元素的表头、所以最后一个是此header的上一个元素
		return header.previous.element;
	}

	/** 删除LinkedList的第一个元素 */
	public E removeFirst() {
		return remove(header.next);
	}

	/** 删除LinkedList的最后一个元素 */
	public E removeLast() {
		return remove(header.previous);
	}

	/** 将元素e添加到LinkedList的起始位置 */
	public void addFirst(E e) {
		addBefore(e, header.next);
	}

	/** 将元素e添加到LinkedList的结束位置 */
	public void addLast(E e) {
		addBefore(e, header);
	}

	/** 判断是否包含Object o */
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	/** 返回LinkedList的大小 */
	public int size() {
		return size;
	}

	/** 将元素(E)添加到LinkedList中、添加到末尾 */
	public boolean add(E e) {
		addBefore(e, header);
		return true;
	}

	/** 从LinkedList中删除o、如果存在则删除第一查找到的o并返回true、若不存在则返回false */
	public boolean remove(Object o) {
		if (o == null) {
			for (Entry<E> e = header.next; e != header; e = e.next) {
				if (e.element == null) {
					remove(e);
					return true;
				}
			}
		} else {
			for (Entry<E> e = header.next; e != header; e = e.next) {
				if (o.equals(e.element)) {
					remove(e);
					return true;
				}
			}
		}
		return false;
	}

	/** 将c中元素添加到双向链表LinkedList中、从尾部开始添加 */
	public boolean addAll(Collection<? extends E> c) {
		return addAll(size, c);
	}

	/** 将c中元素添加到双向链表LinkedList中、所有元素添加到index与index+1表示的元素中间 */
	public boolean addAll(int index, Collection<? extends E> c) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		// 将c转换成数组、方便遍历元素和获取元素个数
		Object[] a = c.toArray();
		int numNew = a.length;
		if (numNew == 0)
			return false;
		modCount++;

		// 设置当前要插入节点的下一个节点
		Entry<E> successor = (index == size ? header : entry(index));
		// 设置当前要插入节点的上一个节点
		Entry<E> predecessor = successor.previous;
		// 将c中元素插入到LinkedList中
		for (int i = 0; i < numNew; i++) {
			Entry<E> e = new Entry<E>((E) a[i], successor, predecessor);
			predecessor.next = e;
			predecessor = e;
		}
		successor.previous = predecessor;
		size += numNew;
		return true;
	}

	/** 删除LinkedList中所有元素 */
	public void clear() {
		Entry<E> e = header.next;
		while (e != header) {
			Entry<E> next = e.next;
			e.next = e.previous = null;
			e.element = null;
			e = next;
		}
		header.next = header.previous = header;
		size = 0;
		modCount++;
	}

	// Positional Access Operations

	/** 获取index处的元素 */
	public E get(int index) {
		return entry(index).element;
	}

	/** 设置index处的元素、并将old元素返回 */
	public E set(int index, E element) {
		Entry<E> e = entry(index);
		E oldVal = e.element;
		e.element = element;
		return oldVal;
	}

	/** 在index前添加节点，且节点的值为element */
	public void add(int index, E element) {
		addBefore(element, (index == size ? header : entry(index)));
	}

	/** 删除index位置的节点 */
	public E remove(int index) {
		return remove(entry(index));
	}

	/** 获取双向链表LinkedList中指定位置的节点、是LinkedList实现List中通过index操作元素的关键 */
	private Entry<E> entry(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		Entry<E> e = header;
		if (index < (size >> 1)) {
			for (int i = 0; i <= index; i++)
				e = e.next;
		} else {
			for (int i = size; i > index; i--)
				e = e.previous;
		}
		return e;
	}

	// Search Operations

	/** 查询o所在LinkedList中的位置的索引、从前向后、不存在返回-1 */
	public int indexOf(Object o) {
		int index = 0;
		if (o == null) {
			for (Entry e = header.next; e != header; e = e.next) {
				if (e.element == null)
					return index;
				index++;
			}
		} else {
			for (Entry e = header.next; e != header; e = e.next) {
				if (o.equals(e.element))
					return index;
				index++;
			}
		}
		return -1;
	}

	/** 查询o所在LinkedList中的位置的索引、从后向前、不存在返回-1 */
	public int lastIndexOf(Object o) {
		int index = size;
		if (o == null) {
			for (Entry e = header.previous; e != header; e = e.previous) {
				index--;
				if (e.element == null)
					return index;
			}
		} else {
			for (Entry e = header.previous; e != header; e = e.previous) {
				index--;
				if (o.equals(e.element))
					return index;
			}
		}
		return -1;
	}

	// Queue operations.

	/** 返回第一个节点、若size为0则返回null */
	public E peek() {
		if (size == 0)
			return null;
		return getFirst();
	}

	/** 返回第一个节点、若size为0则抛异常NoSuchElementException */
	public E element() {
		return getFirst();
	}

	/** 删除并返回第一个节点 、若LinkedList的大小为0,则返回null */
	public E poll() {
		if (size == 0)
			return null;
		return removeFirst();
	}

	/** 删除第一个元素、若LinkedList的大小为0,则抛异常 */
	public E remove() {
		return removeFirst();
	}

	/** 将e添加双向链表末尾 */
	public boolean offer(E e) {
		return add(e);
	}

	// Deque operations
	/** 将e添加双向链表开头 */
	public boolean offerFirst(E e) {
		addFirst(e);
		return true;
	}

	/** 将e添加双向链表末尾 */
	public boolean offerLast(E e) {
		addLast(e);
		return true;
	}

	/** 返回第一个节点、若LinkedList的大小为0,则返回null */
	public E peekFirst() {
		if (size == 0)
			return null;
		return getFirst();
	}

	/** 返回最后一个节点、 若LinkedList的大小为0,则返回null */
	public E peekLast() {
		if (size == 0)
			return null;
		return getLast();
	}

	/** 删除并返回第一个、若LinkedList的大小为0,则返回null */
	public E pollFirst() {
		if (size == 0)
			return null;
		return removeFirst();
	}

	/** 删除并返回最后一个、若LinkedList的大小为0,则返回null */
	public E pollLast() {
		if (size == 0)
			return null;
		return removeLast();
	}

	/** 将e插入到双向链表开头 */
	public void push(E e) {
		addFirst(e);
	}

	/** 删除并返回第一个节点 */
	public E pop() {
		return removeFirst();
	}

	/** 从LinkedList中删除o、如果存在则删除第一查找到的o并返回true、若不存在则返回false */
	public boolean removeFirstOccurrence(Object o) {
		return remove(o);
	}

	/** 从LinkedList末尾向前查找，删除第一个值为元素(o)的节点 */
	public boolean removeLastOccurrence(Object o) {
		if (o == null) {
			for (Entry<E> e = header.previous; e != header; e = e.previous) {
				if (e.element == null) {
					remove(e);
					return true;
				}
			}
		} else {
			for (Entry<E> e = header.previous; e != header; e = e.previous) {
				if (o.equals(e.element)) {
					remove(e);
					return true;
				}
			}
		}
		return false;
	}

	/** 返回“index到末尾的全部节点”对应的ListIterator对象(List迭代器) */
	public ListIterator<E> listIterator(int index) {
		return new ListItr(index);
	}

	private class ListItr implements ListIterator<E> {
		// 上一次返回的节点
		private Entry<E> lastReturned = header;
		// 下一个节点
		private Entry<E> next;
		// 下一个节点对应的索引值
		private int nextIndex;
		// 期望的改变计数。用来实现fail-fast机制。
		private int expectedModCount = modCount;

		// 构造函数、 从index位置开始进行迭代
		ListItr(int index) {
			if (index < 0 || index > size)
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
			/*
			 * 若 “index 小于 ‘双向链表长度的一半’”，则从第一个元素开始往后查找； 否则，从最后一个元素往前查找。
			 */
			if (index < (size >> 1)) {
				next = header.next;
				for (nextIndex = 0; nextIndex < index; nextIndex++)
					next = next.next;
			} else {
				next = header;
				for (nextIndex = size; nextIndex > index; nextIndex--)
					next = next.previous;
			}
		}

		// 是否存在下一个元素
		public boolean hasNext() {
			return nextIndex != size;
		}

		// 获取下一个元素
		public E next() {
			checkForComodification();
			if (nextIndex == size)
				throw new NoSuchElementException();

			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.element;
		}

		// 是否存在上一个元素
		public boolean hasPrevious() {
			return nextIndex != 0;
		}

		// 获取上一个元素
		public E previous() {
			if (nextIndex == 0)
				throw new NoSuchElementException();

			lastReturned = next = next.previous;
			nextIndex--;
			checkForComodification();
			return lastReturned.element;
		}

		// 获取下一个元素的索引
		public int nextIndex() {
			return nextIndex;
		}

		// 获取上一个元素的索引
		public int previousIndex() {
			return nextIndex - 1;
		}

		// 删除双向链表中的当前节点
		public void remove() {
			checkForComodification();
			Entry<E> lastNext = lastReturned.next;
			try {
				LinkedList.this.remove(lastReturned);
			} catch (NoSuchElementException e) {
				throw new IllegalStateException();
			}
			if (next == lastReturned)
				next = lastNext;
			else
				nextIndex--;
			lastReturned = header;
			expectedModCount++;
		}

		// 设置当前节点为e
		public void set(E e) {
			if (lastReturned == header)
				throw new IllegalStateException();
			checkForComodification();
			lastReturned.element = e;
		}

		// 将e添加到当前节点的前面
		public void add(E e) {
			checkForComodification();
			lastReturned = header;
			addBefore(e, next);
			nextIndex++;
			expectedModCount++;
		}

		// 判断 “modCount和expectedModCount是否相等”，以此来实现fail-fast机制。
		final void checkForComodification() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
		}
	}

	/**
	 * 内部静态类、是双向链表的节点所对应的数据结构、 此数据结构包含三部分：上一节点、下一节点、当前节点值
	 */
	private static class Entry<E> {
		// 当前节点值
		E element;
		// 下一节点
		Entry<E> next;
		// 上一节点
		Entry<E> previous;

		/**
		 * 链表节点构造函数
		 * 
		 * @param element
		 *            节点值
		 * @param next
		 *            下一节点
		 * @param previous
		 *            上一节点
		 */
		Entry(E element, Entry<E> next, Entry<E> previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

	// 新建节点、节点值是e、将新建的节点添加到entry之前
	private Entry<E> addBefore(E e, Entry<E> entry) {
		// 觉得难理解的可以先花个几分钟看一下链式结构资料、最好是图片形式的
		// 新建节点实体
		Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
		// 将参照节点原来的上一个节点（即插在谁前面的）的下一个节点设置成newEntry
		newEntry.previous.next = newEntry;
		// 将参照节点（即插在谁前面的）的前一个节点设置成newEntry
		newEntry.next.previous = newEntry;
		size++;
		modCount++;
		return newEntry;
	}

	// 将节点从链表中删除、返回被删除的节点的内容
	private E remove(Entry<E> e) {
		// 如果是表头、抛异常
		if (e == header)
			throw new NoSuchElementException();

		E result = e.element;
		// 下面实际上就是、将e拿掉、然后将e的上下两个节点连接起来
		e.previous.next = e.next;
		e.next.previous = e.previous;
		e.next = e.previous = null;
		e.element = null;
		size--;
		modCount++;
		return result;
	}

	/**
	 * 反向迭代器
	 * 
	 * @since 1.6
	 */
	public Iterator<E> descendingIterator() {
		return new DescendingIterator();
	}

	/** 反向迭代器实现类 */
	private class DescendingIterator implements Iterator {
		final ListItr itr = new ListItr(size());

		public boolean hasNext() {
			return itr.hasPrevious();
		}

		public E next() {
			return itr.previous();
		}

		public void remove() {
			itr.remove();
		}
	}

	/** 返回LinkedList的克隆对象 */
	public Object clone() {
		LinkedList<E> clone = null;
		try {
			clone = (LinkedList<E>) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}

		// Put clone into "virgin" state
		clone.header = new Entry<E>(null, null, null);
		clone.header.next = clone.header.previous = clone.header;
		clone.size = 0;
		clone.modCount = 0;

		// Initialize clone with our elements
		for (Entry<E> e = header.next; e != header; e = e.next)
			clone.add(e.element);

		return clone;
	}

	/** 将LinkedList中的所有元素转换成Object[]中 */
	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Entry<E> e = header.next; e != header; e = e.next)
			result[i++] = e.element;
		return result;
	}

	/** 将LinkedList中的所有元素转换成Object[]中、并且完成类型转换 */
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
		int i = 0;
		Object[] result = a;
		for (Entry<E> e = header.next; e != header; e = e.next)
			result[i++] = e.element;

		if (a.length > size)
			a[size] = null;

		return a;
	}

	private static final long serialVersionUID = 876323262645176354L;

	/**
	 * 将LinkedList的“容量，所有的元素值”都写入到输出流中 1、将LinkedList的容量写入进去
	 * 2、将LinkedList中的所有元素写入进去
	 */
	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
		// Write out any hidden serialization magic
		s.defaultWriteObject();

		// Write out size
		s.writeInt(size);

		// Write out all elements in the proper order.
		for (Entry e = header.next; e != header; e = e.next)
			s.writeObject(e.element);
	}

	/**
	 * 将写入的LinkedList读取出来 1、读取写入的LinkedList的容量 2、读取写入的元素
	 */
	private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
		// Read in any hidden serialization magic
		s.defaultReadObject();

		// Read in size
		int size = s.readInt();

		// Initialize header
		header = new Entry<E>(null, null, null);
		header.next = header.previous = header;

		// Read in all elements in the proper order.
		for (int i = 0; i < size; i++)
			addBefore((E) s.readObject(), header);
	}
}