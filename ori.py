# -*- coding: utf-8 -*-

from aliyunsdkcore.client import AcsClient
from aliyunsdkcore.acs_exception.exceptions import ClientException
from aliyunsdkcore.acs_exception.exceptions import ServerException
from aliyunsdkalidns.request.v20150109.AddDomainRecordRequest import AddDomainRecordRequest
from aliyunsdkalidns.request.v20150109.UpdateDomainRecordRequest import UpdateDomainRecordRequest


"""
添加域名记录
"""
def add_record():

    request = AddDomainRecordRequest()
    request.set_accept_format('json')
    request.set_Value("123.127.36.236")
    request.set_Type("A")
    request.set_RR("xabc")
    request.set_DomainName("haogre.com")
    response = clt.do_action_with_exception(request)
    # python2:  print(response)
    print(str(response, encoding='utf-8'))
    return response



"""
更新阿里云域名解析记录信息
rc_rr = 'q'                 # 解析记录
rc_type = 'a'               # 记录类型, DDNS填写A记录
rc_value = now_ip           # 新的解析记录值
rc_record_id = record_id    # 记录ID
rc_ttl = '1000'             # 解析记录有效生存时间TTL,单位:
print(update_dns(rc_rr, rc_type, rc_value, rc_record_id, rc_ttl, rc_format))
"""

def update_dns(dns_rr, dns_type, dns_value, dns_record_id, dns_ttl, dns_format):
    request = UpdateDomainRecordRequest.UpdateDomainRecordRequest()
    request.set_RR(dns_rr)
    request.set_Type(dns_type)
    request.set_Value(dns_value)
    request.set_RecordId(dns_record_id)
    request.set_TTL(dns_ttl)
    request.set_accept_format(dns_format)
    result = clt.do_action(request)
    return result


