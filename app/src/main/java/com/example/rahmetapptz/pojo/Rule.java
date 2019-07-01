package com.example.rahmetapptz.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rule {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("filial_id")
    @Expose
    private Integer filialId;
    @SerializedName("cashback")
    @Expose
    private String cashback;
    @SerializedName("cashback_limit")
    @Expose
    private Integer cashbackLimit;
    @SerializedName("create_at")
    @Expose
    private String createAt;
    @SerializedName("update_at")
    @Expose
    private Object updateAt;
    @SerializedName("commission")
    @Expose
    private String commission;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("order_min_amount")
    @Expose
    private Integer orderMinAmount;
    @SerializedName("max_pay_amount")
    @Expose
    private Integer maxPayAmount;
    @SerializedName("contract_id")
    @Expose
    private Integer contractId;
    @SerializedName("cashback_account_id")
    @Expose
    private Integer cashbackAccountId;
    @SerializedName("special_offer_type")
    @Expose
    private Object specialOfferType;
    @SerializedName("special_offer_text")
    @Expose
    private Object specialOfferText;
    @SerializedName("grade_id")
    @Expose
    private Object gradeId;
    @SerializedName("cashback_account")
    @Expose
    private CashbackAccount cashbackAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilialId() {
        return filialId;
    }

    public void setFilialId(Integer filialId) {
        this.filialId = filialId;
    }

    public String getCashback() {
        return cashback;
    }

    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    public Integer getCashbackLimit() {
        return cashbackLimit;
    }

    public void setCashbackLimit(Integer cashbackLimit) {
        this.cashbackLimit = cashbackLimit;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Object getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Object updateAt) {
        this.updateAt = updateAt;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getOrderMinAmount() {
        return orderMinAmount;
    }

    public void setOrderMinAmount(Integer orderMinAmount) {
        this.orderMinAmount = orderMinAmount;
    }

    public Integer getMaxPayAmount() {
        return maxPayAmount;
    }

    public void setMaxPayAmount(Integer maxPayAmount) {
        this.maxPayAmount = maxPayAmount;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getCashbackAccountId() {
        return cashbackAccountId;
    }

    public void setCashbackAccountId(Integer cashbackAccountId) {
        this.cashbackAccountId = cashbackAccountId;
    }

    public Object getSpecialOfferType() {
        return specialOfferType;
    }

    public void setSpecialOfferType(Object specialOfferType) {
        this.specialOfferType = specialOfferType;
    }

    public Object getSpecialOfferText() {
        return specialOfferText;
    }

    public void setSpecialOfferText(Object specialOfferText) {
        this.specialOfferText = specialOfferText;
    }

    public Object getGradeId() {
        return gradeId;
    }

    public void setGradeId(Object gradeId) {
        this.gradeId = gradeId;
    }

    public CashbackAccount getCashbackAccount() {
        return cashbackAccount;
    }

    public void setCashbackAccount(CashbackAccount cashbackAccount) {
        this.cashbackAccount = cashbackAccount;
    }
}
