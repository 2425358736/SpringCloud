package com.liuzhiqiang.config.page;

import org.springframework.util.ObjectUtils;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * 类功能描述
 *
 * @author 刘志强
 * @created 2018/3/28.
 */
public class Pagination {

    public Pagination(){
        this.pageSize = 15;
        this.current = 0;
    }
    /**
     * 每页查询条数
     */
    public int pageSize;
    /**
     * 当前页
     */
    public int current;
    /**
     * 排序字段
     */
    public String field;
    /**
     * 排序方式
     */
    public String order;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
//        field = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field);
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if(ObjectUtils.nullSafeEquals(order, "descend")) {
            order = "desc";
        } else if (ObjectUtils.nullSafeEquals(order, "ascend")){
            order = "asc";
        }
        this.order = order;
    }
}
