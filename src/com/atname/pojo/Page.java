package com.atname.pojo;

import java.util.List;

/**
 * Page是分页模型对象
 *
 * @param <T> 是具体的模块的JavaBean类
 * @author 1
 * @create 09-17
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
//    当前页码
    private Integer pageNo;
//    总页码
    private Integer pageTotal;
//    每页数量
    private Integer pageSize = PAGE_SIZE;
//    共多少页数据
    private Integer pageTotalCount;
//    每页数据
    private List<T> items;
//    分页请求的地址
    private String url;

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
//        数据边界的有效检查
        if (pageNo < 1){
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }

        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
