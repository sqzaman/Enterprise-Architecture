package cs544.sdi2.b;

public interface IProductService {
	public Product getProduct(int productNumber);
	public int getNumberInStock(int productNumber);
}
