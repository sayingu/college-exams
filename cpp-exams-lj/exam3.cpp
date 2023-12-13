#include <iostream>
using namespace std;

// Create a class called Matrix for performing arithmetic with 3x3 matrices
class Matrix
{
private:
    // Each element in the matrix should be represented using double precision
    double mat[3][3];

public:
    // Provide a constructor that enables an object to be initialized when it is declared. The constructor should contain default values in case that no initializers are provided.
    Matrix(double a = 0, double b = 0, double c = 0, double d = 0, double e = 0, double f = 0, double g = 0, double h = 0, double i = 0)
    {
        mat[0][0] = a;
        mat[0][1] = b;
        mat[0][2] = c;
        mat[1][0] = d;
        mat[1][1] = e;
        mat[1][2] = f;
        mat[2][0] = g;
        mat[2][1] = h;
        mat[2][2] = i;
    }

    // a) Printing a matrix in the form of a 3x3 array, where each element is separated by a space and each row is separated by a newline.
    void print()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                cout << mat[i][j] << " ";
            }
            cout << endl;
        }
    }

    // b) Overloading the operators +=, -=, *, to simulate the corresponding matrix operations.
    Matrix operator+=(const Matrix &p)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                mat[i][j] += p.mat[i][j];
            }
        }
        return *this;
    }

    // b) Overloading the operators +=, -=, *, to simulate the corresponding matrix operations.
    Matrix operator-=(const Matrix &p)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                mat[i][j] -= p.mat[i][j];
            }
        }
        return *this;
    }

    // b) Overloading the operators +=, -=, *, to simulate the corresponding matrix operations.
    Matrix operator*(const Matrix &p) const
    {
        Matrix res;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                res.mat[i][j] = mat[i][j] * p.mat[i][j];
            }
        }
        return res;
    }
};

int main()
{
    Matrix m1(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Matrix m2(9, 8, 7, 6, 5, 4, 3, 2, 1);
    Matrix m3 = m1 * m2;
    m1 += m2;
    m2 -= m1;

    cout << "Matrix 1:" << endl;
    m1.print();
    cout << endl;

    cout << "Matrix 2:" << endl;
    m2.print();
    cout << endl;

    cout << "Matrix 3:" << endl;
    m3.print();
    cout << endl;

    return 0;
}
