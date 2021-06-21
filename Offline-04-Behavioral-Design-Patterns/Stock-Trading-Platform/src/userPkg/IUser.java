package userPkg;

import stockPkg.Stock;

public interface IUser {
    void Subscribe(Stock s);
    void UnSubscribe(Stock s);
    void Update(Stock s, String msg);
}
