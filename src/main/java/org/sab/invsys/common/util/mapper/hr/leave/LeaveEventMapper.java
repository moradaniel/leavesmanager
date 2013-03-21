package org.sab.invsys.common.util.mapper.hr.leave;

import java.util.ArrayList;
import java.util.List;

import org.sab.invsys.persistence.model.hr.leave.LeaveEvent;
import org.sab.invsys.persistence.model.user.User;
import org.sab.invsys.web.model.hr.leave.LeaveEventUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class LeaveEventMapper {
	public LeaveEventUI toUIBean(LeaveEvent data) {
		LeaveEventUI ui = new LeaveEventUI();

		if (data != null) {
			/*ui.setComments(data.getComments());
			ui.setCreateadBy(data.getCreateadBy());
			ui.setCreatedDate(data.getCreatedDate());
			ui.setDiscount(data.getDiscount());
			ui.setDueDate(data.getDueDate());*/
			ui.setId(data.getId());
			ui.setFromDate(data.getFromDate());
			ui.setToDate(data.getToDate());
			
			/*ui.setModifiedBy(data.getModifiedBy());
			ui.setModifiedDate(data.getModifiedDate());
			ui.setOrderDate(data.getOrderDate());
			ui.setOrderId(data.getOrderId());
			ui.setOrderType(data.getOrderType());
			ui.setReferenceNumber(data.getReferenceNumber());*/
			ui.setFirstName(data.getUser().getFirstName());
			ui.setLastName(data.getUser().getLastName());
			ui.setUserName(data.getUser().getUsername());
			//ui.setTotal(data.getTotal());

		}

		return ui;
	}

	public List<LeaveEventUI> toUIBean(List<LeaveEvent> data) {
		List<LeaveEventUI> ui = new ArrayList<LeaveEventUI>();

		for (LeaveEvent po : data) {
			ui.add(toUIBean(po));
		}

		return ui;
	}

	public Page<LeaveEventUI> toUIBean(Page<LeaveEvent> data,
			Pageable pageable) {
		return new PageImpl<LeaveEventUI>(toUIBean(data.getContent()));
	}

	public LeaveEvent toPersistenceBean(LeaveEventUI ui) {
		LeaveEvent data = new LeaveEvent();

		if (ui != null) {
			/*data.setComments(ui.getComments());
			data.setCreateadBy(ui.getCreateadBy());
			data.setCreatedDate(ui.getCreatedDate());
			data.setDiscount(ui.getDiscount());
			data.setDueDate(ui.getDueDate());*/
			data.setId(ui.getId());
			/*data.setModifiedBy(ui.getModifiedBy());
			data.setModifiedDate(ui.getModifiedDate());
			data.setOrderDate(ui.getOrderDate());
			data.setOrderId(ui.getOrderId());
			data.setOrderType(ui.getOrderType());
			data.setReferenceNumber(ui.getReferenceNumber());*/

			data.setFromDate(ui.getFromDate());
			data.setToDate(ui.getToDate());
			
			User user = new User();
			user.setUsername(ui.getUserName());
			data.setUser(user);

			/*if (ui.getCharges() != null && ui.getCharges().size() > 0) {
				PurchaseOrderChargesMapper chargeMapper = new PurchaseOrderChargesMapper();
				Set<PurchaseOrderCharges> charges = new HashSet<PurchaseOrderCharges>(
						chargeMapper.toPersistenceBean(ui.getCharges()));
				data.setCharges(charges);
			}
			if (ui.getItems() != null && ui.getItems().size() > 0) {
				PurchaseOrderItemsMapper itemsMapper = new PurchaseOrderItemsMapper();
				List<PurchaseOrderItems> pItems = itemsMapper
						.toPersistenceBean(ui.getItems());
				Set<PurchaseOrderItems> items = new HashSet<PurchaseOrderItems>();
				if (pItems != null) {
					items.addAll(pItems);
				}
				data.setItems(items);
			}
			if (ui.getTaxes() != null && ui.getTaxes().size() > 0) {
				PurchaseOrderTaxesMapper taxMapper = new PurchaseOrderTaxesMapper();
				Set<PurchaseOrderTaxes> taxes = new HashSet<PurchaseOrderTaxes>(
						taxMapper.toPersistenceBean(ui.getTaxes()));
				data.setTaxes(taxes);
			}*/
		}

		return data;
	}

	public List<LeaveEvent> toPersistenceBean(List<LeaveEventUI> ui) {
		List<LeaveEvent> data = new ArrayList<LeaveEvent>();

		for (LeaveEventUI po : ui) {
			data.add(toPersistenceBean(po));
		}

		return data;
	}
}
