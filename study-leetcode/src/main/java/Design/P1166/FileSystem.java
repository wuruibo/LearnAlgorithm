package Design.P1166;

import java.util.HashMap;
import java.util.Map;

class FileSystem {

    private Map<String,Integer> fileMap;// 文件路径

    public FileSystem() {
        fileMap = new HashMap<>();
        // 缓存根节点路径
        fileMap.put("",-1);
    }

    public boolean createPath(String path, int value) {
        // 没有删除的文件的情况，path只要存在，就一直存在
        if (fileMap.containsKey(path)){
            return false;// 文件已经存在了，返回false
        }
        // 获取父路径
        int lastIndex = path.lastIndexOf("/");
        String parentPath = path.substring(0,lastIndex);
        // 父路径不存在，则返回false
        if (!fileMap.containsKey(parentPath)){
            return false;
        }
        // 文件记录
        fileMap.put(path,value);
        return true;
    }

    public int get(String path) {
        // 获取文件的值，不存在就是-1
        return fileMap.getOrDefault(path,-1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */

