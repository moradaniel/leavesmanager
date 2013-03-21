package org.sab.invsys.web.controller.hr.leave;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.sab.invsys.common.util.extjs.FilterRequest;
import org.sab.invsys.common.util.extjs.JsonUtils;
import org.sab.invsys.common.util.extjs.ResponseMap;
import org.sab.invsys.service.hr.leave.LeaveEventService;
import org.sab.invsys.web.controller.product.ProductController;
import org.sab.invsys.web.model.hr.leave.LeaveEventUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/leaveevent")
public class LeaveEventController {
	@Autowired
	private LeaveEventService service;

	@Autowired
	private ResponseMap<LeaveEventUI> response;
	/*@Autowired
	private ResponseMap<PurchaseOrderItemsUI> itemsResponse;
	@Autowired
	private ResponseMap<TransactionAmountSummary> purchaseResponse;*/

	//PurchaseOrderItemJson itemsJson = new PurchaseOrderItemJson();

	private Logger logger = Logger.getLogger(ProductController.class);

	@RequestMapping
	public String startPage() {
		return "leaveevent/summary";
	}

	@RequestMapping(value = "/leaveeventList")
	public String listPage() {
		return "leaveevent/list";
	}

	@RequestMapping(value = "/list")
	public @ResponseBody
	Map<String, ? extends Object> list(@RequestParam int page,
			@RequestParam int start, @RequestParam int limit,
			@RequestParam(required = false) Object filter) throws Exception {
		try {
			Pageable pageable = new PageRequest(page - 1, limit);
			Page<LeaveEventUI> leaveEvents = null;

			List<FilterRequest> filters = new ArrayList<FilterRequest>();

			if (filter != null) {
				logger.debug("Processing Filters!");
				filters.addAll(JsonUtils.getListFromJsonArray((String) filter));
			}

			leaveEvents = service.findAll(pageable, filters);
			long total = leaveEvents.getTotalElements();
			logger.debug("purchases : " + leaveEvents.getContent());

			return response.mapOK(leaveEvents.getContent(), total);
		} catch (Exception e) {
			logger.error(e);
			return response
					.mapError("Error retrieving LeaveEvents from database.");
		}
	}

	@RequestMapping(value = "/view/{leaveEventId}")
	public String view(@PathVariable String leaveEventId, Model model)
			throws Exception {
		LeaveEventUI leaveEvent = service.findByLeaveEventId(Long.parseLong(leaveEventId));

		model.addAttribute("poBean", leaveEvent);

		return "leaveevent/view";
	}

	/*@RequestMapping(value = "/view/{id}/itemList")
	public @ResponseBody
	Map<String, ? extends Object> itemList(@PathVariable Integer id)
			throws Exception {
		try {
			List<PurchaseOrderItemsUI> purchasedItems = new ArrayList<PurchaseOrderItemsUI>();
			if (id != null && !"".equals(id)) {
				purchasedItems = service.findItemsByOrderId(id);
			}
			return itemsResponse.mapOK(purchasedItems);
		} catch (Exception e) {
			logger.error(e);
			return response
					.mapError("Error retrieving Purchases from database.");
		}
	}*/

	/*
	@RequestMapping(value = "/update")
	public @ResponseBody
	Map<String, ? extends Object> update(@RequestParam String orderId,
			@RequestParam String userName,
			@RequestParam String referenceNumber,
			@RequestParam String orderType, @RequestParam Date orderDate,
			@RequestParam Date dueDate, @RequestParam String comments,
			@RequestParam Object items) throws Exception {
		try {
			PurchaseOrderUI order = new PurchaseOrderUI();
			order.setOrderId(orderId);
			order.setUserName(userName);
			order.setReferenceNumber(referenceNumber);
			order.setOrderType(orderType);
			order.setOrderDate(orderDate);
			order.setDueDate(dueDate);
			order.setComments(comments);
			List<PurchaseOrderItemsUI> pItems = itemsJson
					.getListFromJSON((String) items);
			order.setItems(pItems);
			logger.debug("Purchased Items :: " + pItems);
			logger.debug("Purchas Order :: " + order);

			PurchaseOrderUI purchase = service.update(order);

			if (purchase == null) {
				return response.mapError("Purchase Order Id doesn't exists.");
			} else {
				return response.mapOK(purchase,
						"Purchase Order Updated Succesfully");
			}
		} catch (Exception e) {
			logger.error(e);
			return response.mapError("Error trying to update Purchase Order.");
		}
	}*/

	/*@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "purchaseorder/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> add(@RequestParam String orderId,
			@RequestParam String userName,
			@RequestParam String referenceNumber,
			@RequestParam String orderType, @RequestParam Date orderDate,
			@RequestParam Date dueDate, @RequestParam String comments,
			@RequestParam Object items) {
		try {
			PurchaseOrderUI order = new PurchaseOrderUI();
			order.setOrderId(orderId);
			order.setUserName(userName);
			order.setReferenceNumber(referenceNumber);
			order.setOrderType(orderType);
			order.setOrderDate(orderDate);
			order.setDueDate(dueDate);
			order.setComments(comments);
			List<PurchaseOrderItemsUI> pItems = itemsJson
					.getListFromJSON((String) items);
			order.setItems(pItems);
			logger.debug("Purchased Items :: " + pItems);
			logger.debug("Purchas Order :: " + order);

			if (service.findByOrderId(order.getOrderId()).getOrderId() != null) {
				return response.mapError("Order Id already exists.");
			}
			PurchaseOrderUI saved = service.create(order);
			logger.debug("Purchas Order Created Successfully :: " + saved);
			return response.mapOK(saved, "Purchase Order Created Succesfully");
		} catch (Exception e) {
			logger.error("Error trying to create purchase order.");
			return response.mapError("Error trying to create purchase order.");
		}
	}
*/
	/*
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "purchases") String orderIds) {
		try {

			List<PurchaseOrderUI> deletedPurchases = new ArrayList<PurchaseOrderUI>();

			for (String orderId : orderIds.substring(1, orderIds.length() - 1)
					.replaceAll("\"", "").split(",")) {
				PurchaseOrderUI product = service.findByOrderId(orderId);

				if (product != null) {
					service.delete(product);
					deletedPurchases.add(product);
				}
			}

			return response.mapOK(deletedPurchases);
		} catch (Exception e) {
			e.printStackTrace();
			return response.mapError("Error trying to delete purchase orders.");
		}
	}

	@RequestMapping(value = "/monthlySummary", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, ? extends Object> monthSalesSummary(
			@RequestParam(required = false) String month,
			@RequestParam(required = false) String year, Object filter) {
		try {
			int curMonth = month != null && Integer.parseInt(month) > 0 ? Integer
					.parseInt(month) : Calendar.getInstance().get(
					Calendar.MONTH);
			int curYear = year != null && Integer.parseInt(year) > 0 ? Integer
					.parseInt(year) : Calendar.getInstance().get(Calendar.YEAR);

			return purchaseResponse.mapOK(service.monthlyPurchases(curMonth + 1,
					curYear));
		} catch (Exception e) {
			e.printStackTrace();
			return response
					.mapError("Error trying to fetch monthly sales summary.");
		}
	}

	@RequestMapping(value = "/yealySummary", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, ? extends Object> yearlySalesSummary(
			@RequestParam(required = false) String year, Object filter) {
		try {
			int curYear = year != null && Integer.parseInt(year) > 0 ? Integer
					.parseInt(year) : Calendar.getInstance().get(Calendar.YEAR);
			List<TransactionAmountSummary> yearlySales = service.yearlyPurchases(curYear);

			for (TransactionAmountSummary ss : yearlySales) {
				ss.setDay(new DateFormatSymbols().getMonths()[Integer
						.parseInt(ss.getDay()) - 1]);
			}

			return purchaseResponse.mapOK(yearlySales);
		} catch (Exception e) {
			e.printStackTrace();
			return response
					.mapError("Error trying to fetch monthly sales summary.");
		}
	}

	@RequestMapping(value = "/allSummary", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, ? extends Object> allSalesSummary(Object filter) {
		try {
			return purchaseResponse.mapOK(service.allYearPurchases());
		} catch (Exception e) {
			e.printStackTrace();
			return response
					.mapError("Error trying to fetch monthly sales summary.");
		}
	}*/
}
