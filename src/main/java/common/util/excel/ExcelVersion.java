package common.util.excel;

/**
 * excel版本枚举
 *
 * @author Person
 * @date 2020年07月15日
 */
public enum ExcelVersion {

    /**
     * 虽然V2007版本支持最大支持1048575 * 16383 ，
     * V2003版支持65535*255
     * 但是在实际应用中如果使用如此庞大的对象集合会导致内存溢出，
     * 因此这里限制最大为10000*100，如果还要加大建议先通过单元测试进行性能测试。
     * 1000*100 全部导出预计时间为27s左右
     */
    V2003(".xls"),
    V2007(".xlsx");

    private final String suffix;

    ExcelVersion(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return this.suffix;
    }

}