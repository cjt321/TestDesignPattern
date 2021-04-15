package com.cjt.desigmode.decorator.data;

/**
 * 装饰者.
 * 例子：对敏感数据进行压缩和加密， 从而将数据从使用数据的代码中独立出来。
 *
 * --装饰者Decorator--
 * 加密、压缩
 *
 * --被装饰者--
 * 数据：二进制数据、文件数据
 */
public class DataDecoratorMain {

    public static void main(String[] args) {
        new Client().fileProcessing();
    }

}

//客户端
class Client{
    public void fileProcessing(){
        System.out.println("---二进制处理---");
        IData dataProcess = new Binary();
        dataProcess = new Compress(dataProcess);
        dataProcess = new Encryption(dataProcess);
        dataProcess.processing();

        System.out.println("\n\n\n---文件处理---");
        IData fileProcess = new File();
        fileProcess = new Compress(fileProcess);
        fileProcess.processing();
    }
}

//被装饰者
interface IData{
    //文件处理
    void processing();
}

//被装饰者，文件
class File implements IData{

    @Override
    public void processing() {
        System.out.println("文件已经处理。");
    }
}

//被装饰者，二进制
class Binary implements IData{

    @Override
    public void processing() {
        System.out.println("二进制已经处理。");
    }
}

//装饰者
abstract class DataDecorator implements IData{
    private IData data;

    public DataDecorator(IData data){
        this.data = data;
    }

    @Override
    public void processing() {
        data.processing();
    }
}

//压缩
class Compress extends DataDecorator{

    public Compress(IData data) {
        super(data);
    }

    @Override
    public void processing() {
        System.out.println("--开始压缩--");
        super.processing();
        System.out.println("--结束压缩--");
    }
}

//加密
class Encryption extends DataDecorator {

    public Encryption(IData data) {
        super(data);
    }

    @Override
    public void processing() {
        System.out.println("--开始加密--");
        super.processing();
        System.out.println("--结束加密--");
    }
}