package ai.spring.demo.ai.playground.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.math.BigDecimal;
import java.util.Date;

/**
 * 库存台账对象 wms_inventory_details
 *
 * @author weifu
 * @date 2022-12-28
 */
public class InventoryDetails  {
    private static final long serialVersionUID = 1L;

    /**
     * 库存数量库存数量总数，instore模块中InventoryDetailsController的list方法使用
     */
    private BigDecimal inventoryQtySum;

    /**
     * 主键
     */
    private Long id;

    /**
     * 物料号
     */

    private String materialNo;

    /**
     * 物料名称
     */

    private String materialName;

    /**
     * 旧物料号
     */
    private String oldMaterialNo;

    /**
     * 仓位
     */
    private String positionNo;

    /**
     * 仓位id
     */
    private Long positionId;

    /**
     * 区域id
     */
    private Long areaId;

    /**
     * 区域
     */
    private String areaCode;

    /**
     * 序列号
     */
    private String seqNo;

    /**
     * 库存地点id
     */
    private Long locationId;

    /**
     * 库存地点Code
     */
    private String locationCode;

    /**
     * 工厂ID
     */
    private Long factoryId;

    /**
     * 工厂代码
     */
    private String factoryCode;

    /**
     * 工厂名称
     */
    //@Excel(name = "工厂名称")
    private String factoryName;

    /**
     * 库存数量
     */
    private BigDecimal inventoryQty;

    /**
     * 可用数量
     */
    private BigDecimal availableQty;

    /**
     * 备货数量
     */
    private BigDecimal preparedQty;

    /**
     * 特殊库存标识
     */
    private String stockSpecFlag;

    /**
     * 特殊库存类型
     */
    private String stockSpecType;

    private String billType;

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    /**
     * 入库批次
     */
    private String stockInLot;

    /** 是否质检*/
    private String isQc;

    /**
     * 生产批次
     */
    private String productionLot;

    /**
     * 有效期
     */
    private BigDecimal validDays;

    /**
     * 有效期截止日期
     */
    @JSONField(format = "dd/MM/yyyy HH:mm:ss")
    private Date expiryDate;

    /**
     * 是否冻结: 1是 0否
     */
    private String isFreeze;

    /**
     * 是否寄售: 1是 0否
     */
    private String isConsign;

    /**
     * 特殊标记
     */
    //@Excel(name = "特殊标记")
    private String specFlag;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 供应商代码
     */
    private String supplierCode;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 容器号
     */
    private String containerNo;

    /**
     * 容器类型
     */
    //@Excel(name = "容器类型")
    private String containerType;

    /**
     * 入库日期
     */
    @JSONField(format = "dd/MM/yyyy HH:mm:ss")
    private Date stockInDate;

    /**
     * 租户号
     */
    private Long tenantId;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 仓库ID
     */
    private Long warehouseId;

    /**
     * 仓库代码
     */
    private String warehouseCode;

    /**
     * 是否预定: 1是 0否
     */
    private String isReserved;

    /**
     * 预定数量
     */
    private BigDecimal reservedQty;

    /**
     * 默认单位
     */
    private String unit;
    /**
     * 操作单位
     */
    private String operationUnit;

    /**
     * 默认单位换算
     */
    private BigDecimal conversDefault;
    /**
     * 库存操作数量
     */
    private BigDecimal operationInventoryQty;
    /**
     * 可用操作数量
     */
    private BigDecimal operationAvailableQty;
    /**
     * 备货操作数量
     */
    private BigDecimal operationPreparedQty;

    /** 库存类型 */
    private String locationType;

    /** 特殊库存 */
    private String specialType;

    /** WBS元素 */
    private String wbsElement;

    /** 原mes容器号 */
    private String oldMesContainerNo;

    /** 原数量 */
    private String oldQty;
    /** hu号 */
    private String huNo;

    /** 生产日期 */
    @JSONField(format = "dd/MM/yyyy HH:mm:ss")
    private Date productTime;


    /**
     * 移动类型
     */
    private String moveType;

    private String flag;
    /*** 任务号*/
    private String taskNo;


    @JSONField(
            format = "dd/MM/yyyy HH:mm:ss"
    )
    private Date createTime;

    @JSONField(
            format = "dd/MM/yyyy HH:mm:ss"
    )
    private Date updateTime;

    private String updateBy;
    /**
     * mrp 标识
     */
    private String mrp;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getSpecFlag() {
        return specFlag;
    }

    public void setSpecFlag(String specFlag) {
        this.specFlag = specFlag;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }
    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public String getWbsElement() {
        return wbsElement;
    }

    public void setWbsElement(String wbsElement) {
        this.wbsElement = wbsElement;
    }

    public String getOldMesContainerNo() {
        return oldMesContainerNo;
    }

    public void setOldMesContainerNo(String oldMesContainerNo) {
        this.oldMesContainerNo = oldMesContainerNo;
    }

    public String getOldQty() {
        return oldQty;
    }

    public void setOldQty(String oldQty) {
        this.oldQty = oldQty;
    }

    public String getHuNo() {
        return huNo;
    }

    public void setHuNo(String huNo) {
        this.huNo = huNo;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public BigDecimal getInventoryQtySum() {
        return inventoryQtySum;
    }

    public void setInventoryQtySum(BigDecimal inventoryQtySum) {
        this.inventoryQtySum = inventoryQtySum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setOldMaterialNo(String oldMaterialNo) {
        this.oldMaterialNo = oldMaterialNo;
    }

    public String getOldMaterialNo() {
        return oldMaterialNo;
    }

    public void setPositionNo(String positionNo) {
        this.positionNo = positionNo;
    }

    public String getPositionNo() {
        return positionNo;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setInventoryQty(BigDecimal inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    public BigDecimal getInventoryQty() {
        return inventoryQty;
    }

    public void setAvailableQty(BigDecimal availableQty) {
        this.availableQty = availableQty;
    }

    public BigDecimal getAvailableQty() {
        return availableQty;
    }

    public void setPreparedQty(BigDecimal preparedQty) {
        this.preparedQty = preparedQty;
    }

    public BigDecimal getPreparedQty() {
        return preparedQty;
    }

    public void setStockSpecFlag(String stockSpecFlag) {
        this.stockSpecFlag = stockSpecFlag;
    }

    public String getStockSpecFlag() {
        return stockSpecFlag;
    }

    public void setStockSpecType(String stockSpecType) {
        this.stockSpecType = stockSpecType;
    }

    public String getStockSpecType() {
        return stockSpecType;
    }

    public void setStockInLot(String stockInLot) {
        this.stockInLot = stockInLot;
    }

    public String getStockInLot() {
        return stockInLot;
    }

    public void setProductionLot(String productionLot) {
        this.productionLot = productionLot;
    }

    public String getProductionLot() {
        return productionLot;
    }

    public void setValidDays(BigDecimal validDays) {
        this.validDays = validDays;
    }

    public BigDecimal getValidDays() {
        return validDays;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setIsFreeze(String isFreeze) {
        this.isFreeze = isFreeze;
    }

    public String getIsFreeze() {
        return isFreeze;
    }



    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setStockInDate(Date stockInDate) {
        this.stockInDate = stockInDate;
    }

    public Date getStockInDate() {
        return stockInDate;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public String getIsConsign() {
        return isConsign;
    }

    public void setIsConsign(String isConsign) {
        this.isConsign = isConsign;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(String isReserved) {
        this.isReserved = isReserved;
    }

    public BigDecimal getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(BigDecimal reservedQty) {
        this.reservedQty = reservedQty;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getIsQc() {
        return isQc;
    }

    public void setIsQc(String isQc) {
        this.isQc = isQc;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOperationUnit() {
        return operationUnit;
    }

    public void setOperationUnit(String operationUnit) {
        this.operationUnit = operationUnit;
    }

    public BigDecimal getOperationInventoryQty() {
        return operationInventoryQty;
    }

    public void setOperationInventoryQty(BigDecimal operationInventoryQty) {
        this.operationInventoryQty = operationInventoryQty;
    }

    public BigDecimal getOperationAvailableQty() {
        return operationAvailableQty;
    }

    public void setOperationAvailableQty(BigDecimal operationAvailableQty) {
        this.operationAvailableQty = operationAvailableQty;
    }

    public BigDecimal getOperationPreparedQty() {
        return operationPreparedQty;
    }

    public void setOperationPreparedQty(BigDecimal operationPreparedQty) {
        this.operationPreparedQty = operationPreparedQty;
    }

    public BigDecimal getConversDefault() {
        return conversDefault;
    }

    public void setConversDefault(BigDecimal conversDefault) {
        this.conversDefault = conversDefault;
    }

    @Override
    public String toString() {
        return "InventoryDetails{" +
                "inventoryQtySum='" + inventoryQtySum + '\'' +
                ", id=" + id +
                ", materialNo='" + materialNo + '\'' +
                ", materialName='" + materialName + '\'' +
                ", oldMaterialNo='" + oldMaterialNo + '\'' +
                ", positionNo='" + positionNo + '\'' +
                ", positionId=" + positionId +
                ", areaId=" + areaId +
                ", areaCode='" + areaCode + '\'' +
                ", seqNo='" + seqNo + '\'' +
                ", locationId=" + locationId +
                ", locationCode='" + locationCode + '\'' +
                ", factoryId=" + factoryId +
                ", factoryCode='" + factoryCode + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", inventoryQty=" + inventoryQty +
                ", availableQty=" + availableQty +
                ", preparedQty=" + preparedQty +
                ", stockSpecFlag='" + stockSpecFlag + '\'' +
                ", stockSpecType='" + stockSpecType + '\'' +
                ", stockInLot='" + stockInLot + '\'' +
                ", isQc='" + isQc + '\'' +
                ", productionLot='" + productionLot + '\'' +
                ", validDays=" + validDays +
                ", expiryDate=" + expiryDate +
                ", isFreeze='" + isFreeze + '\'' +
                ", isConsign='" + isConsign + '\'' +
                ", supplierId=" + supplierId +
                ", supplierCode='" + supplierCode + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", containerNo='" + containerNo + '\'' +
                ", containerType='" + containerType + '\'' +
                ", stockInDate=" + stockInDate +
                ", tenantId=" + tenantId +
                ", deptId=" + deptId +
                ", warehouseId=" + warehouseId +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", isReserved='" + isReserved + '\'' +
                ", reservedQty=" + reservedQty +
                ", unit='" + unit + '\'' +
                ", operationUnit='" + operationUnit + '\'' +
                ", conversDefault=" + conversDefault +
                ", operationInventoryQty=" + operationInventoryQty +
                ", operationAvailableQty=" + operationAvailableQty +
                ", operationPreparedQty=" + operationPreparedQty +
                '}';
    }
}
