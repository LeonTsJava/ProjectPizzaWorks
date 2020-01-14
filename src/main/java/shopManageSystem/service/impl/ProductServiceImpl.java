package shopManageSystem.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _model.ProductBean;
import _model.SalesOrderBean;
import shopManageSystem.dao.ProductDao;
import shopManageSystem.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	ProductDao dao; 
	
	@Override
	@Autowired
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public List<ProductBean> getAllProducts(){
		return dao.getAllProducts();
	}
	
	@Transactional
	@Override
	public ProductBean getProductById(Integer productId) {
		return dao.getProductById(productId);
	}
	
	@Transactional
	@Override
	public void updateOneProduct(ProductBean pb) {
		dao.updateOneProduct(pb);
	}

	@Transactional
	@Override
	public List<SalesOrderBean> getAllSalesOrders(){
		return dao.getAllSalesOrders();
	}
	
	@Transactional
	@Override
	public SalesOrderBean getSalesOrderById(Integer salesOrderId) {
		return dao.getSalesOrderById(salesOrderId);
	}
}
