package main.proxy;

public interface Person {
    /**
     * @param name 人名
     * @param dst  工作目的地
     */
    void goWorking(String name, String dst);

    /**
     * 获取名称
     *
     * @return
     */
    String getName();

    /**
     * 设置名称
     *
     * @param name
     */
    void setName(String name);
}