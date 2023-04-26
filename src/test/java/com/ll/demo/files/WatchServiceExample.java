package com.ll.demo.files;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

public class WatchServiceExample {

    @Test
    public void testHuWatchMonitor() {
        File file = FileUtil.file("D:\\tmp");
        //这里只监听文件或目录的修改事件
        WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.ENTRY_CREATE);
        watchMonitor.setWatcher(new Watcher() {
            @Override
            public void onCreate(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("创建：{}-> {}", currentPath, obj);
            }

            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("修改：{}-> {}", currentPath, obj);
            }

            @Override
            public void onDelete(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("删除：{}-> {}", currentPath, obj);
            }

            @Override
            public void onOverflow(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("Overflow：{}-> {}", currentPath, obj);
            }
        });

        //设置监听目录的最大深入，目录层级大于制定层级的变更将不被监听，默认只监听当前层级目录
        watchMonitor.setMaxDepth(Integer.MAX_VALUE);
        //启动监听
        watchMonitor.start();


        while (true) ;
    }

}
/*
* Path dir = Paths.get("path/to/directory");
WatchService watchService = FileSystems.getDefault().newWatchService();
*
*
* Files.walk(dir).forEach(path -> {
    try {
        if (Files.isDirectory(path)) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        }
    } catch (IOException e) {
        System.err.println(e);
    }
});
*
*java
while (true) {
    WatchKey key = watchService.take(); // 获取监听器的事件
    for (WatchEvent<?> event : key.pollEvents()) {
        WatchEvent<Path> ev = (WatchEvent<Path>) event;
        Path fileName = ev.context();
        Path filePath = ((Path) key.watchable()).resolve(fileName); // 获取文件完整路径
        if (Files.isDirectory(filePath)) { // 若为新增目录，递归注册监听
            filePath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        } else { // 处理新增文件
            if (fileName.toString().endsWith(".zip")) { // 根据文件后缀名判断是否为 zip 文件
                System.out.println("New file added: " + filePath);
                // ...
            }
        }
    }
    key.reset(); // 重置监听器
}
*
* */
