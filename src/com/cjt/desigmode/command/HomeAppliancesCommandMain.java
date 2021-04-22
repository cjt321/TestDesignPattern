package com.cjt.desigmode.command;

/**
 * 命令模式。
 *
 * ---角色---
 * 调用者：命令的调用者，聚合命令接口（以数组方式聚合）。
 * 接受者：有多少种类型，就有多少个接受者。
 * 命令接口：命令的接口，一般两个方法，execute与undo。作为调用者+接受者的中间过渡角色。
 * 命令实现类：有多少种命令+类型，就有多少个命令类。
 *
 *
 * ---例子---
 * 用遥控来控制不同的家电。如风扇（Fan）的开关、冰箱（Refrigerator）的开关、洗衣机（WashingMachine）的开关。
 * 调用者：RemoteControl（遥控器）
 * 接受者：FanReceiver（风扇接收者）、RefrigeratorReceiver（冰箱接收者）、WashingMachineReceiver（洗衣机接收者）
 * 命令接口：IHomeAppliancesCommand（家电命令接口）
 * 命令实现类：风扇开（FanOpenCommand）、风扇关（FanCloseCommand）、冰箱开（RefrigeratorOpenCommand）、
 * 冰箱关（RefrigeratorCloseCommand）、洗衣机开（WashingMachineOpenCommand）、
 * 洗衣机关（WashingMachineCloseCommand）
 */
public class HomeAppliancesCommandMain {

    public static void main(String[] args) {

        //初始化，添加到遥控器
        RemoteControl remoteControl = new RemoteControl();

        FanReceiver fanReceiver = new FanReceiver();
        FanOpenCommand fanOpenCommand = new FanOpenCommand(fanReceiver);
        FanCloseCommand fanCloseCommand = new FanCloseCommand(fanReceiver);

        RefrigeratorReceiver refrigeratorReceiver = new RefrigeratorReceiver();
        RefrigeratorOpenCommand refrigeratorOpenCommand = new RefrigeratorOpenCommand(refrigeratorReceiver);
        RefrigeratorCloseCommand refrigeratorCloseCommand = new RefrigeratorCloseCommand(refrigeratorReceiver);

        WashingMachineReceiver washingMachineReceiver = new WashingMachineReceiver();
        WashingMachineOpenCommand washingMachineOpenCommand = new WashingMachineOpenCommand(washingMachineReceiver);
        WashingMachineCloseCommand washingMachineCloseCommand = new WashingMachineCloseCommand(washingMachineReceiver);

        remoteControl.addCommand(0, fanOpenCommand, fanCloseCommand);
        remoteControl.addCommand(1, refrigeratorOpenCommand, refrigeratorCloseCommand);
        remoteControl.addCommand(2, washingMachineOpenCommand, washingMachineCloseCommand);

        //执行
        remoteControl.on(1);
        remoteControl.on(2);
        remoteControl.close(0);

        remoteControl.undo();
    }
}

//遥控命令调用者
class RemoteControl{

    private IHomeAppliancesCommand[] onCommands;
    private IHomeAppliancesCommand[] closeCommands;

    private IHomeAppliancesCommand latestCommand;

    public RemoteControl(){
        onCommands = new IHomeAppliancesCommand[3];
        closeCommands = new IHomeAppliancesCommand[3];
    }

    public void addCommand(int idx, IHomeAppliancesCommand openCommand, IHomeAppliancesCommand closeCommand){
        onCommands[idx] = openCommand;
        closeCommands[idx] = closeCommand;
    }


    public void close(int idx){
        latestCommand = closeCommands[idx];
        closeCommands[idx].execute();
    }

    public void on(int idx){
        latestCommand = onCommands[idx];
        onCommands[idx].execute();
    }

    public void undo(){
        latestCommand.undo();
    }

}

//家电命令接口
interface IHomeAppliancesCommand{
    void execute();
    void undo();
}

//风扇打开命令
class FanOpenCommand implements IHomeAppliancesCommand{

    private FanReceiver fanReceiver;

    public FanOpenCommand(FanReceiver fanReceiver){
        this.fanReceiver = fanReceiver;
    }

    @Override
    public void execute() {
        fanReceiver.open();
    }

    @Override
    public void undo() {
        fanReceiver.close();
    }
}

//风扇关闭命令
class FanCloseCommand implements IHomeAppliancesCommand{

    private FanReceiver fanReceiver;

    public FanCloseCommand(FanReceiver fanReceiver){
        this.fanReceiver = fanReceiver;
    }

    @Override
    public void execute() {
        fanReceiver.close();
    }

    @Override
    public void undo() {
        fanReceiver.open();
    }
}

//冰箱打开命令
class RefrigeratorOpenCommand implements IHomeAppliancesCommand{

    private RefrigeratorReceiver refrigeratorReceiver;

    public RefrigeratorOpenCommand(RefrigeratorReceiver refrigeratorReceiver){
        this.refrigeratorReceiver = refrigeratorReceiver;
    }

    @Override
    public void execute() {
        refrigeratorReceiver.open();
    }

    @Override
    public void undo() {
        refrigeratorReceiver.close();
    }
}

//冰箱关闭命令
class RefrigeratorCloseCommand implements IHomeAppliancesCommand{

    private RefrigeratorReceiver refrigeratorReceiver;

    public RefrigeratorCloseCommand(RefrigeratorReceiver refrigeratorReceiver){
        this.refrigeratorReceiver = refrigeratorReceiver;
    }

    @Override
    public void execute() {
        refrigeratorReceiver.close();
    }

    @Override
    public void undo() {
        refrigeratorReceiver.open();
    }
}

//洗衣机开命令
class WashingMachineOpenCommand implements IHomeAppliancesCommand{

    private WashingMachineReceiver washingMachineReceiver;

    public WashingMachineOpenCommand(WashingMachineReceiver washingMachineReceiver){
        this.washingMachineReceiver = washingMachineReceiver;
    }

    @Override
    public void execute() {
        washingMachineReceiver.open();
    }

    @Override
    public void undo() {
        washingMachineReceiver.close();
    }
}

//洗衣机关命令
class WashingMachineCloseCommand implements IHomeAppliancesCommand{

    private WashingMachineReceiver washingMachineReceiver;

    public WashingMachineCloseCommand(WashingMachineReceiver washingMachineReceiver){
        this.washingMachineReceiver = washingMachineReceiver;
    }

    @Override
    public void execute() {
        washingMachineReceiver.close();
    }

    @Override
    public void undo() {
        washingMachineReceiver.open();
    }
}

//风扇接收者
class FanReceiver{
    public void close(){
        System.out.println("风扇关闭");
    }

    public void open(){
        System.out.println("风扇打开");
    }
}

//冰箱接收者
class RefrigeratorReceiver{

    public void close(){
        System.out.println("冰箱关闭");
    }

    public void open(){
        System.out.println("冰箱打开");
    }
}

//洗衣机接受者
class WashingMachineReceiver{

    public void close(){
        System.out.println("洗衣机关闭");
    }

    public void open(){
        System.out.println("洗衣机打开");
    }
}