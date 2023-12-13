#include <iostream>
using namespace std;

class Score
{
private:
    Score *m_pNext;
    Score *m_pPrev;
    double m_Avg;

public:
    Score() : m_pNext(0), m_pPrev(0), m_Avg(0.0) {}

    void SetAvg(double avg) { m_Avg = avg; }
    void SetNext(Score *pNext) { m_pNext = pNext; }
    void SetPrev(Score *pPrev) { m_pPrev = pPrev; }
    double GetAvg() { return m_Avg; }
    Score *GetNext() { return m_pNext; }
    Score *GetPrev() { return m_pPrev; }
};

class StudentScoreList
{
private:
    Score *m_pHead;
    Score *m_pTail;

public:
    StudentScoreList() : m_pHead(0), m_pTail(0) {}

    // Note that when implementing the “Insert()” function in a StudentScoreList class, the Score nodes should be linked into ascending order by average score.
    void Insert(Score *pScore)
    {
        if (m_pHead == 0)
        {
            // 최초 입력
            m_pHead = pScore;
            m_pTail = pScore;
        }
        else if (pScore->GetAvg() < m_pHead->GetAvg())
        {
            // 입력된 Score가 m_pHead 보다 작음

            // 1. 입력된 Score 객체의 SetNext
            pScore->SetNext(m_pHead);

            // 2. 이전 m_pHead 의 SerPrev
            m_pHead->SetPrev(pScore);

            // 3. m_pHead 는 입력된 Score
            m_pHead = pScore;
        }
        else if (pScore->GetAvg() >= m_pTail->GetAvg())
        {
            // 입력된 Score가 m_pTail 보다 큼

            // 1. 입력된 Score 객체의 SetPrev
            pScore->SetPrev(m_pTail);

            // 2. 이전 m_pTail 의 SerPrev
            m_pTail->SetNext(pScore);

            // 3. m_pTail 는 입력된 Score
            m_pTail = pScore;
        }
        else
        {
            // 입력된 Score가 m_pHead, m_pTail 사이

            // 1. 시작은 m_pHead 부터
            Score *pCurrent = m_pHead;

            while (pCurrent->GetNext() != 0 && pCurrent->GetNext()->GetAvg() <= pScore->GetAvg())
            {
                // 2. 입력된 Score보다 초과될 때 까지 GetNext
                pCurrent = pCurrent->GetNext();
            }

            // 3. 입력된 Score 객체의 SetNext, SetPrev
            pScore->SetNext(pCurrent->GetNext());
            pScore->SetPrev(pCurrent);
        }
    }

    // And the “PrintList()” function prints all the average scores in “Score” nodes as ascending or descending order according to the parameters, “IsAscending”. (Ascending order if “is Ascending” is true, otherwise, descending order is used.)
    void PrintList(bool isAscending)
    {
        Score *pCurrent = 0;
        if (isAscending)
        {
            // 오름차순은 m_pHead 부터 시작
            pCurrent = m_pHead;
        }
        else
        {
            // 내림차순은 m_pTail 부터 시작
            pCurrent = m_pTail;
        }

        while (pCurrent != 0)
        {
            // GetNext, GetPrev 값이 0이 될때 까지 출력
            cout << pCurrent->GetAvg() << " ";
            if (isAscending)
            {
                // 오름차순은 GetNext
                pCurrent = pCurrent->GetNext();
            }
            else
            {
                // 내림차순은 GetPrev
                pCurrent = pCurrent->GetPrev();
            }
        }

        cout << endl;
    }
};

int main()
{
    StudentScoreList scoreList;

    double mathScore, englishScore, scienceScore, avgScore;
    Score *score;

    cout << "Enter the scores for student1 (math, english, science):" << endl;
    cin >> mathScore >> englishScore >> scienceScore;
    avgScore = (mathScore + englishScore + scienceScore) / 3.0;
    score = new Score();
    score->SetAvg(avgScore);
    scoreList.Insert(score);

    cout << "Enter the scores for student2 (math, english, science):" << endl;
    cin >> mathScore >> englishScore >> scienceScore;
    avgScore = (mathScore + englishScore + scienceScore) / 3.0;
    score = new Score();
    score->SetAvg(avgScore);
    scoreList.Insert(score);

    cout << "Enter the scores for student3 (math, english, science):" << endl;
    cin >> mathScore >> englishScore >> scienceScore;
    avgScore = (mathScore + englishScore + scienceScore) / 3.0;
    score = new Score();
    score->SetAvg(avgScore);
    scoreList.Insert(score);

    cout << "Average scores in ascending order: ";
    scoreList.PrintList(true);

    cout << "Average scores in descending order: ";
    scoreList.PrintList(false);

    return 0;
}
