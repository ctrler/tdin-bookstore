/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.up.fe.tdin.bookstore.store;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pt.up.fe.tdin.bookstore.common.Book;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "myWebService")
@Stateless()
public class myWebService {
    @EJB
    private Operations ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getBook")
    public Book getBook(@WebParam(name = "id") int id) {
        return ejbRef.getBook(id);
    }

    @WebMethod(operationName = "getBookList")
    public List<Book> getBookList() {
        return ejbRef.getBookList();
    }

    @WebMethod(operationName = "getBookStockLeft")
    public int getBookStockLeft(@WebParam(name = "id") int id) {
        return ejbRef.getBookStockLeft(id);
    }

    @WebMethod(operationName = "setBookAvailability")
    @Oneway
    public void setBookAvailability(@WebParam(name = "id") int id, @WebParam(name = "availability") int availability) {
        ejbRef.setBookAvailability(id, availability);
    }

    @WebMethod(operationName = "placeOrder")
    public Boolean placeOrder(@WebParam(name = "bookId") int bookId, @WebParam(name = "quantity") int quantity, @WebParam(name = "name") String name, @WebParam(name = "address") String address, @WebParam(name = "email") String email) {
        return ejbRef.placeOrder(bookId, quantity, name, address, email);
    }

    @WebMethod(operationName = "changeOrderState")
    @Oneway
    public void changeOrderState(@WebParam(name = "id") int id, @WebParam(name = "state") String state) {
        ejbRef.changeOrderState(id, state);
    }

    @WebMethod(operationName = "setOrderDeliveryDate")
    @Oneway
    public void setOrderDeliveryDate(@WebParam(name = "id") int id, @WebParam(name = "date") Date date) {
        ejbRef.setOrderDeliveryDate(id, date);
    }
    
}
