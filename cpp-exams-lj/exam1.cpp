#include <iostream>
using namespace std;

// Create class called Sale that has price (type double, private) and public functions are shown below.
class Sale
{
private:
    double Price;

public:
    Sale() {
        Price = 0;
    }
    Sale(double ThePrice)
    {
        // At first, the input data are price of the item.
        Price = ThePrice;
    }
    virtual ~Sale() {}

    double GetPrice()
    {
        return Price;
    }
    // Function Bill is declared to be a virtual function.
    virtual double Bill() {
        return 0;
    }
    double Savings(Sale &Other)
    {
        return Bill() - Other.Bill();
    }
    bool operator<(Sale &Other)
    {
        return Bill() < Other.Bill();
    }
};

// You should create the DiscountSale class which inherits from Sale class. It has a private value named DiscountPercent (type double) and public funcitons.
class DiscountSale : public Sale
{
private:
    // DiscountPercent is member variable in DiscountSale class.
    double DiscountPercent;

public:
    DiscountSale(double ThePrice, double TheDiscountPercent)
        : Sale(ThePrice)
    {
        DiscountPercent = TheDiscountPercent;
    }

    // If a function is virtual, a new definition of the function is given in a derived class, then for any object of the derived class, that object will always use the definition of the virtual function that was given in the derived class.
    // The class also has a Bill function which calculates the discount price using the GetPrice function in Sale class
    double Bill() override
    {
        double discount = GetPrice() * (DiscountPercent / 100.0);
        return GetPrice() - discount;
    }
};

int main()
{
    cout << "===================================" << endl;
    cout << "Price Compare Program" << endl;
    cout << "===================================" << endl;

    double item1Price, item2Price;
    cout << "Insert item1 price: $";
    cin >> item1Price;
    cout << "Insert item2 price: $";
    cin >> item2Price;

    double discountPercent;
    cout << "-----------------------------------------------------------" << endl;
    cout << "Insert discount percent: ";
    cin >> discountPercent;

    DiscountSale item1(item1Price, discountPercent);
    DiscountSale item2(item2Price, discountPercent);

    cout << "-----------------------------------------------------------" << endl;
    cout << "Result:" << endl;
    if (item1 < item2)
    {
        cout << "Discount price of item1 is cheaper." << endl;
        cout << "Saving discount price is $" << item2.Savings(item1) << endl;
    }
    else if (item2 < item1)
    {
        cout << "Discount price of item2 is cheaper." << endl;
        cout << "Saving discount price is $" << item1.Savings(item2) << endl;
    }
    else
    {
        cout << "Both items have the same discount price." << endl;
    }

    return 0;
}
