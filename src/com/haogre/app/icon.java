
    public static void main(String[] args) throws Exception {
        String names = readJsonFile("/Users/3t/Downloads/get_smartisan_icon_pack-master/apps_category.json");

        JSONObject namesObj = JSONObject.parseObject(names);
        Iterator<String> keys = namesObj.keySet().iterator();
        int j = 0;

        ArrayList<String> keysList = new ArrayList<>();
        while (keys.hasNext()) {
            String key = keys.next();
            keysList.add(key);
        }
        keysList.parallelStream().forEach(key -> {
            try {
                getIcon(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("all is done");
    }
    public static void getIcon(String key) throws Exception {
        try {
            HashMap<String, String> param = new HashMap<>();
            param.put("package", key);
            ArrayList<Object> objects = new ArrayList<>();
            objects.add(param);

            String rs = HttpUtils.postJson("http://setting.smartisan.com/app/icon", JSON.toJSONString(objects));
            JSONObject rsObj = JSONObject.parseObject(rs);
            JSONObject jsonObject = rsObj.getJSONObject("body").getJSONObject("app_icon");
            JSONArray jsonArray = jsonObject.getJSONArray(key);
            int i = 0;
            for (Object o : jsonArray) {
                JSONObject o1 = (JSONObject) o;
                String logo = o1.getString("logo");
            String cmdStr = "";
            if (i == 0 ) {
            cmdStr = "curl " + logo + " --output /Users/3t/Desktop/icons/" + key +".png";
            } else {
            cmdStr = "curl " + logo + " --output /Users/3t/Desktop/icons/" + key + "_" + i +".png";
            }
            System.out.println(cmdStr);
//                String result = execCmd("java -version", null);

                CompletableFuture.runAsync(() -> {

                });
                String result = execCmd(cmdStr, null);
                System.out.println(result);
                i++;
            }
            System.out.println(1);
        } catch (Exception  e){
            System.out.println(key);
            System.out.println("未找到tt图标");
        }
    }

    /**
     * 执行系统命令, 返回执行结果
     *
     * @param cmd 需要执行的命令
     * @param dir 执行命令的子进程的工作目录, null 表示和当前主进程工作目录相同
     */
    public static String execCmd(String cmd, File dir) throws Exception {
        StringBuilder result = new StringBuilder();

        Process process = null;
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null, dir);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                result.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                result.append(line).append('\n');
            }

        } finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }

        // 返回执行结果
        return result.toString();
    }

    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }

    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }