package com.liuweiwei.dao;

import com.liuweiwei.entity.ClaimVoucher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);

    void delete(int id);

    void update(ClaimVoucher claimVoucher);

    ClaimVoucher select(int id);

    List<ClaimVoucher> selectByCreateSn(String csn);

    List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
