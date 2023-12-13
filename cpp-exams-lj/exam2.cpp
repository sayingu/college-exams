#include <iostream>
using namespace std;

class Person
{
protected:
    int age;
    char name[50];

public:
    Person()
    {
        age = 0;
        name[0] = '\0';
    }
    ~Person() {}
    virtual void Say() = 0;
};

class Professor : public Person
{
private:
    // Professor class has extra member variables of a professor number and a major
    int professorNumber;
    char major[50];

public:
    Professor()
    {
        professorNumber = 0;
        major[0] = '\0';
    }
    ~Professor() {}
    Professor(int pAge, const char *pName, int pProfessorNumber, const char *pMajor)
    {
        age = pAge;

        const char *src = pName;
        char *dest = name;
        while (*src)
        {
            *dest = *src;
            src++;
            dest++;
        }
        *dest = '\0';

        professorNumber = pProfessorNumber;

        src = pMajor;
        dest = major;
        while (*src)
        {
            *dest = *src;
            src++;
            dest++;
        }
        *dest = '\0';
    }

    // Override Say function for inherited classes to display all member variables in the class object
    void Say() override
    {
        cout << "I'm a professor of KW University." << endl;
        cout << "My name is " << name << "." << endl;
        cout << "I'm " << age << " years old." << endl;
        cout << "I'm majoring in " << major << "." << endl;
    }
};

class Student : public Person
{
private:
    // Student class has additional member variables of a student number, a major and a school year
    int studentNumber;
    char major[50];
    int schoolYear;

public:
    Student()
    {
        studentNumber = 0;
        major[0] = '\0';
        schoolYear = 0;
    }
    ~Student() {}

    Student(int pAge, const char *pName, int pStudentNumber, const char *pMajor, int pSchoolYear)
    {
        age = pAge;

        const char *src = pName;
        char *dest = name;
        while (*src)
        {
            *dest = *src;
            src++;
            dest++;
        }
        *dest = '\0';

        studentNumber = pStudentNumber;

        src = pMajor;
        dest = major;
        while (*src)
        {
            *dest = *src;
            src++;
            dest++;
        }
        *dest = '\0';

        schoolYear = pSchoolYear;
    }

    // Override Say function for inherited classes to display all member variables in the class object
    void Say() override
    {
        cout << "I'm a student of KW University." << endl;
        cout << "My name is " << name << "." << endl;
        cout << "I'm " << age << " years old and I'm in " << schoolYear << " grade" << endl;
        cout << "I'm majoring in " << major << "." << endl;
    }
};

int main()
{
    Professor professor(48, "Jaewook Lee", 1998002, "Computer Engineering");
    professor.Say();

    cout << endl;

    Student student(21, "Leejoon Hong", 2023005, "Computer Engineering", 2);
    student.Say();

    return 0;
}
