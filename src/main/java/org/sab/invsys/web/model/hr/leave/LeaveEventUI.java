package org.sab.invsys.web.model.hr.leave;

import java.util.Date;

public class LeaveEventUI {
	private Long id;
	private Date fromDate;
	private Date toDate;
	
	//private String orderId;
	/*private String orderType;
	private String comments;
	private String referenceNumber;
	private int discount;
	private long total;
	private Date orderDate;
	private Date dueDate;
	private Date createdDate;
	private Date modifiedDate;
	private int createadBy;
	private int modifiedBy;*/
	private String userName;
	private String firstName;
	private String lastName;
	/*private List<PurchaseOrderItemsUI> purchasedItems;
	private List<PurchaseOrderChargesUI> charges;
	private List<PurchaseOrderTaxesUI> taxes;*/

	public LeaveEventUI(Long id,
			Date fromDate,
			Date toDate,
			
			/*String orderId, String orderType,
			String comments, String referenceNumber, int discount,
			Date orderDate, Date dueDate, Date createdDate, Date modifiedDate,
			int createadBy, int modifiedBy,
			*/
			String userName,
			String firstName,
			String lastName
			/*,
			List<PurchaseOrderItemsUI> items,
			List<PurchaseOrderChargesUI> charges,
			List<PurchaseOrderTaxesUI> taxes*/) {
		super();
		this.id = id;
		/*this.orderId = orderId;
		this.orderType = orderType;
		this.comments = comments;
		this.referenceNumber = referenceNumber;
		this.discount = discount;
		this.orderDate = orderDate;
		this.dueDate = dueDate;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createadBy = createadBy;
		this.modifiedBy = modifiedBy;*/
		this.userName = userName;
		/*this.purchasedItems = items;
		this.charges = charges;
		this.taxes = taxes;*/
	}

	public LeaveEventUI() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getCreateadBy() {
		return createadBy;
	}

	public void setCreateadBy(int createadBy) {
		this.createadBy = createadBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}*/

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
/*
	public List<PurchaseOrderItemsUI> getItems() {
		return purchasedItems;
	}

	public void setItems(List<PurchaseOrderItemsUI> items) {
		this.purchasedItems = items;
	}

	public List<PurchaseOrderChargesUI> getCharges() {
		return charges;
	}

	public void setCharges(List<PurchaseOrderChargesUI> charges) {
		this.charges = charges;
	}

	public List<PurchaseOrderTaxesUI> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<PurchaseOrderTaxesUI> taxes) {
		this.taxes = taxes;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
*/
	@Override
	public String toString() {
		return "LeaveEventUI [id=" +/* id + ", orderId=" + orderId
				+ ", orderType=" + orderType + ", comments=" + comments
				+ ", referenceNumber=" + referenceNumber + ", discount="
				+ discount + ", orderDate=" + orderDate + ", dueDate="
				+ dueDate + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", createadBy=" + createadBy + ", modifiedBy="
				+ modifiedBy + ", userName=" + userName + ", items=" + purchasedItems
				+ ", charges=" + charges + ", taxes=" + taxes + */"]";
	}
}
