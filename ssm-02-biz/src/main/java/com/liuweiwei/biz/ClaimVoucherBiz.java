package com.liuweiwei.biz;

import com.liuweiwei.entity.ClaimVoucher;
import com.liuweiwei.entity.ClaimVoucherItem;
import com.liuweiwei.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimVoucherBiz {

    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItems(int cvid);
    List<DealRecord> getRecords(int cvid);

    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
    void submit(int id);
    void deal(DealRecord dealRecord);
}
