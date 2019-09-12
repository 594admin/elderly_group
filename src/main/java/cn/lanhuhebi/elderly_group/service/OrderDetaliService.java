package cn.lanhuhebi.elderly_group.service;

public interface OrderDetaliService {
    /**
     *
     * @param od_or_id
     * @return
     */
    int addOrderDetail(Integer od_or_id);


    /**
     * 安装信息
     * @param odId
     * @param odEmpNo
     * @param odPhoto
     * @return
     */
    boolean updateOrderDetail(Integer odId,String odEmpNo,String odPhoto);

}
