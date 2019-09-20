package AlibabaProblem;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @autor yeqiaozhu.
 * @date 2019-09-03
 */

public class FundNetValue {
    /**
     * 日期
     */
    private Date netValueDate;
    /**
     * 净值
     */
    private BigDecimal netValue;

    public FundNetValue() {
    }

    public FundNetValue(Date netValueDate, BigDecimal netValue) {
        this.netValueDate = netValueDate;
        this.netValue = netValue;
    }

    public Date getNetValueDate() {
        return netValueDate;
    }

    public void setNetValueDate(Date netValueDate) {
        this.netValueDate = netValueDate;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }
}
