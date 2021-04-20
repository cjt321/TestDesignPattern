package com.cjt.desigmode.templatemethod.dm;

import javax.print.Doc;

/**
 * 模板方法。
 *
 * 例子：
 * 假如你正在开发一款分析公司文档的数据挖掘程序。 用户需要向程序输入各种格式 （PDF、 DOC 或 CSV） 的文档，程序则会试图从这些文件中抽取有意义的数据，并以统一的格式将其返回给用户。
 * 步骤：读取文件->分析数据->取得想要数据->关闭取数据
 *
 * 模板抽象类：数据挖掘AbsFileDataMining，模板方法dataMining，步骤：读取文件readFile->分析数据dataAnalyse->取得想要数据getDataYouWant->关闭取数据closeFile。
 * pdf文件：PdfFileDataMining
 * doc文件：DocFileDataMining
 * csv文件：CsvFileDataMining
 */
public class TemplateMethodDataMiningMain {

    public static void main(String[] args) {
        var pdfFileDm = new PdfFileDataMining();
        var pdfresult = pdfFileDm.dataMining();
        System.out.println("pdf分析结束，我想要的数据是：" + pdfresult);

        var docFileDm = new DocFileDataMining();
        var docresult = docFileDm.dataMining();
        System.out.println("doc分析结束，我想要的数据是：" + docresult);

        var csvFileDm = new CsvFileDataMining();
        var csvresult = csvFileDm.dataMining();
        System.out.println("csv分析结束，我想要的数据是：" + csvresult);
    }
}

//模板抽象方法，数据挖掘
abstract class AbsFileDataMining{
    //数据分析
    public final String dataMining(){
        readFile();
        dataAnalyse();
        String md = getDataYouWant();
        closeFile();
        return md;
    }

    //文件读取
    protected abstract void readFile();

    //分析数据
    protected abstract void dataAnalyse();

    //取得想要数据
    protected abstract String getDataYouWant();

    //关闭取数据
    protected abstract void closeFile();

}

//pdf
class PdfFileDataMining extends AbsFileDataMining{

    @Override
    protected void readFile() {
        System.out.println("读取pdf文件");
    }

    @Override
    protected void dataAnalyse() {
        System.out.println("分析pdf文件");
    }

    @Override
    protected String getDataYouWant() {
        System.out.println("从pdf文件取得我想要的数据");
        return "xxx-pdf";
    }

    @Override
    protected void closeFile() {
        System.out.println("关闭pdf文件");
    }
}

class DocFileDataMining extends AbsFileDataMining{
    @Override
    protected void readFile() {
        System.out.println("读取doc文件");
    }

    @Override
    protected void dataAnalyse() {
        System.out.println("分析doc文件");
    }

    @Override
    protected String getDataYouWant() {
        System.out.println("从doc文件取得我想要的数据");
        return "xxx-doc";
    }

    @Override
    protected void closeFile() {
        System.out.println("关闭doc文件");
    }
}

class CsvFileDataMining extends AbsFileDataMining{
    @Override
    protected void readFile() {
        System.out.println("读取csv文件");
    }

    @Override
    protected void dataAnalyse() {
        System.out.println("分析csv文件");
    }

    @Override
    protected String getDataYouWant() {
        System.out.println("从csv文件取得我想要的数据");
        return "xxx-csv";
    }

    @Override
    protected void closeFile() {
        System.out.println("关闭csv文件");
    }
}