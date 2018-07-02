package com.neuedu.model;

import java.io.Serializable;

public class Page implements Serializable{
	private static final long serialVersionUID=1L;

    private int pageNow=1;      //��ǰҲ��

    private int pageSize=3;     //ÿҳ��ʾ������

    private int totalCount;     //�ܼ�¼��

    private int totalPageCount;      //��ҳ��

    private int startPos;        //��ʼλ�ã���0��ʼ

    private boolean hasFrist;      //�Ƿ�����ҳ

    private boolean hasPre;     //�Ƿ���ǰһҳ

    private boolean hasNext;     //�Ƿ��к�һҳ

    private boolean hasLast;     //�Ƿ���βҳ

    /**
     * ͨ�����캯���������ܼ�¼���͵�ǰҳ
     * @param pageNow
     * @param totalCount
     */
    public Page(int pageNow, int totalCount) {
        super();
        this.pageNow = pageNow;
        this.totalCount = totalCount;
    }
    //��ȡ��ҳ��
    public int getTotalPageCount() {
        totalPageCount=getTotalCount()/getPageSize();
        return (totalCount%pageSize==0) ? totalPageCount:totalPageCount+1;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    //ȡ��ѡ���¼�ĳ�ʼλ��
    public int getStartPos() {
        return (pageNow-1)*pageSize;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }
    //�ж��Ƿ��е�һҳ
    public boolean isHasFrist() {
        return (pageNow==1) ? false:true;
    }

    public void setHasFrist(boolean hasFrist) {
        this.hasFrist = hasFrist;
    }
    //�������ҳ����ǰһҳ
    public boolean isHasPre() {
        return isHasFrist() ? true:false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }
    //�����βҳ������һҳ
    public boolean isHasNext() {
        return isHasNext() ? true:false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
    //�ж��Ƿ���βҳ
    public boolean isHasLast() {
        return (pageNow==getTotalCount()) ? false:true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }
}
