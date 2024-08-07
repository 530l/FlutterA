package com.example.fluttera

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MyApp : Application() {
    lateinit var flutterEngine: FlutterEngine

    override fun onCreate() {
        super.onCreate()
        // ① 创建Flutter引擎实例
        flutterEngine = FlutterEngine(this)

        // 启动Flutter的代码执行，从默认的入口点 (通常是main()函数) 开始。
        flutterEngine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())

        // 将预热好的 FlutterEngine实例 放入缓存，使用 my_engine_id 作为其标识符
        FlutterEngineCache.getInstance().put("my_engine_id", flutterEngine)
    }
}
