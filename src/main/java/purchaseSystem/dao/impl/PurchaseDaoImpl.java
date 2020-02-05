package purchaseSystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _model.MaterialsBean;
import _model.PurchaseOrderBean;
import _model.PurchaseOrderDetailBean;
import _model.PurchaseRequestBean;
import _model.PurchaseRequestDetailBean;
import _model.SupplierBean;
import purchaseSystem.dao.PurchaseDao;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	SessionFactory factory;

	@Override
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	// 1-1.查詢所有請購單
	public List<PurchaseRequestBean> getAllPurchaseRequest() {
		String hql = "FROM PurchaseRequestBean";
		Session session = null;
		List<PurchaseRequestBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	// 1-2.查詢單一請購單(依請購單ID)
	public PurchaseRequestBean getOnePurchaseRequestById(Integer pRequestId) {
		Session session = factory.getCurrentSession();
		PurchaseRequestBean prb = session.get(PurchaseRequestBean.class, pRequestId);
		return prb;
	}

	// 2-1.新增請購單
	@Override
	public Integer insertOnePurchaseRequest(PurchaseRequestBean prb) {
		Session session = factory.getCurrentSession();
		Integer pRequestId = (Integer) session.save(prb);
		// 把新的請購單Id再set進Bean中？因為剛剛前端傳來的Bean中還沒有Id，現在set給它
		prb.setpRequestId(pRequestId);
		return pRequestId;
	}

	// 2-2.新增請購單明細
	@Override
	public void insertOnePurchaseRequestDetail(PurchaseRequestDetailBean purchaseRequestDetail) {
		Session session = factory.getCurrentSession();
		session.save(purchaseRequestDetail);
	}

	// 3-1.修改請購單
	@Override
	public void updatePurchaseRequest(PurchaseRequestBean prb) {
		// 請購單僅須被改兩處：PurchaseReason、TotalPrice
		Session session = factory.getCurrentSession();
		PurchaseRequestBean oldPrb = session.get(PurchaseRequestBean.class, prb.getpRequestId());
		if (prb.getPurchaseReason() != null) {
			if (!prb.getPurchaseReason().equals("")) {
				oldPrb.setPurchaseReason(prb.getPurchaseReason());
			}
		}
		if (prb.getTotalPrice() != null) {
			oldPrb.setTotalPrice(prb.getTotalPrice());
		}
	}

	// 3-2.修改請購單明細
	@Override
	public void updatePurchaseRequestDetail(PurchaseRequestDetailBean prdb) {
		// 請購單明細僅須被改兩處：UnitPrice、Quantity
		Session session = factory.getCurrentSession();
		PurchaseRequestDetailBean oldBean = session.get(PurchaseRequestDetailBean.class, prdb.getpRequestDetailId());
		if (prdb.getUnitPrice() != null) {
			oldBean.setUnitPrice(prdb.getUnitPrice());
		}
		if (prdb.getQuantity() != null) {
			oldBean.setQuantity(prdb.getQuantity());
		}
	}

	// 4.刪除單一請購單明細
	@Override
	public void deleteOnePurchaseDetail(PurchaseRequestDetailBean oprdb) {
		Session session = factory.getCurrentSession();
		session.delete(oprdb);
		System.out.println("已刪除欲刪之請購單品項");
	}

	// 1.查詢所有採購單
	@Override
	public List<PurchaseOrderBean> getAllPurchaseOrder() {
		String hql = "FROM PurchaseOrderBean";
		Session session = null;
		List<PurchaseOrderBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	// 2-1.新增採購單
	@Override
	public Integer insertOnePurchaseOrder(PurchaseOrderBean pob) {
		Session session = factory.getCurrentSession();
		Integer pOrderId = (Integer) session.save(pob);
		// 把新的請購單Id再set進Bean中？因為剛剛前端傳來的Bean中還沒有Id，現在set給它
		pob.setpOrderId(pOrderId);
		return pOrderId;
	}

	// 2-2.新增採購單明細
	@Override
	public void insertOnePurchaseOrderDetail(PurchaseOrderDetailBean purchaseOrderDetail) {
		Session session = factory.getCurrentSession();
		session.save(purchaseOrderDetail);
	}

	@Override
	public MaterialsBean getOneMaterialsById(Integer MaterialId) {
		Session session = factory.getCurrentSession();
		MaterialsBean mb = session.get(MaterialsBean.class, MaterialId);
		return mb;
	}

	@Override
	// 查詢單一供應商資料(依廠商ID)
	public SupplierBean getOneSupplierById(Integer supplierId) {
		Session session = factory.getCurrentSession();
		SupplierBean sb = session.get(SupplierBean.class, supplierId);
		return sb;
	}

	@Override
	public List<MaterialsBean> getMaterialList() {
		String hql = "FROM MaterialsBean";
		Session session = factory.getCurrentSession();
		List<MaterialsBean> materials = session.createQuery(hql).getResultList();
		return materials;
	}
	
	@Override
	public void deleteOnePurchaseDetail(PurchaseRequestDetailBean oprdb) {
		Session session = factory.getCurrentSession();
		session.delete(oprdb);
		System.out.println("已刪除欲刪之請購單品項");
	}
	
	@Override
	public void updateReadTime(PurchaseRequestBean purchaseRq) {
		Session session = factory.getCurrentSession();
		PurchaseRequestBean PRB = session.get(PurchaseRequestBean.class, purchaseRq.getpRequestId());
		PRB.setReadTime(purchaseRq.getReadTime());
	}

}
