 |:black_square_button: :heavy_check_mark: :white_check_mark:
:white_square_button: :ballot_box_with_check:

Expected tasks:

1. Count volume of water
2. Come up with my own cypher
3. Make a method arraycopy in MyString
4. Find two different strings with equal hash 
5. Add to chess castling of king and rook
6. Come up with my own strategy in Game theory and implement it
---

---

### 06.08.24
- :heavy_check_mark: 1 - в задаче про переворот слов в строке применить разворот из шифра (НОРМАЛЬНЫМ методом)
   - вспомогательный метод, который переворачивает String
   - отсутствие конкатенации стрингов (не использовать + )   
---

- 2 реализовать в классе MyString следующие методы:

  - :heavy_check_mark: `indexOf` 
  - :heavy_check_mark: `lastIndexOf`
  - :heavy_check_mark: `split`
  - :heavy_check_mark: `toUppercase`
  - :heavy_check_mark: `toLowerCase`
  - :heavy_check_mark: `concat`
  - :heavy_check_mark: `contains`
  - :heavy_check_mark: `isEmpty` 
  - :heavy_check_mark: `repeat`
  - :heavy_check_mark: `isBlank`
---


- :heavy_check_mark: 3:

- :heavy_check_mark: склонить репозиторий по ссылке в телеге, импортировать проект в IDE (file -> new -> project from ES)
разобраться с кодом, почитать, что там есть, подумать:
 - Далее см. __21.08.24__
---

---

---

### 13.08.24
   - :heavy_check_mark: 1 - в SimpleChess проекте наладить распечатку доски
      - выровнять вертикали
      - буквенные обозначения верикалей тоже выровнять
---
   - 2 - реализовать остальные методы MyString
---

---

---

### 18.08.24
:heavy_check_mark: 1 - в SimpleChess починить расположение белых и черных фигур, (см. [chess](https://lichess.org/analysis))
 - :heavy_check_mark: 1.1 - починить нумерацию строк (снизу вверх)

- 2 - продолжить реализацию методов MyString

---

---

---

### 21.08.24
- :heavy_check_mark: 1 - добавить equals and hashCode to MyString 

2 - шахматы:
- :heavy_check_mark: как можно было улучшить.
- :heavy_check_mark: разобраться в каком формате он ожидает выполнение ходов
- :heavy_check_mark: проверить возможность сделать ход (например: e2, e4)
---

---

---

### 29.08.24
- :heavy_check_mark: 1 переделать equals так, чтоб сравнивал не по ссылке, а по содержанию
- :heavy_check_mark: 2 отдебажить ход черных, и разобраться почему не ходят как положено
---

---

---
### 04.09.24
- :heavy_check_mark: подумать и попытаться реализовать ввод ходов в человеческом формате (вместо 2е-4е - е2-е4)
- :heavy_check_mark: подумать о том, как избавиться от дублирования кода для белых и черных (ходы)
---

---

---
### 09.09.24
- :heavy_check_mark: 1 починить энд и резайн, и сделать чтоб побеждала правильная сторона
- :heavy_check_mark: 2 ознакомиться с дилеммой заключенного -> реализовать программу для дилеммы заключенного
---

---

---
### 12.09.24
- :heavy_check_mark: 1 реализовать tit fot tat (око за око)
- :heavy_check_mark: 2 реализовать стратегию кооперироваться, но каждый пятый ход предавать
---

---

---
### 19.09.24
- :heavy_check_mark: 1 tit for double tat (дефектит только за два подряд дефекта)
- :heavy_check_mark: 2 изначально кооперируется, но если получил дефект - дефектит до конца (злопамятный)
---

---

---
### 30.09.24
- :heavy_check_mark: 1 реализовать чемпионат стратегий
---

---

---

### 03.10.24
- :heavy_check_mark: 1 доделать стратегию (удвоенная месть)
- :heavy_check_mark: 2 выровнять табличку с результатами в консоли
- :heavy_check_mark: 3 после таблички с результатми, отступив 1 строчку, печатать кто чемпион
---

---

---
### 07.10.24
1. :heavy_check_mark: разобраться с кодом TicTacToe (импорт и т.д)
---

---

---
### 13.10.24
- :heavy_check_mark: 1 баг со вводом некорректного хода
  - steps to reproduce:
    - choose human vs. comp - 1
    - board size - 3
    - first move - 4b
    - actual result - X appears in 1c square
    - expected result—message about wrong move format
- :heavy_check_mark: 3 баг со вводом некорректного размера поля
   - steps to reproduce:
     - choose human vs. comp - 1
     - board size - 2b
     - actual result - exception message
     - expected result - proper message, ask for one more try
---

---

---
### 16.10.24
- [ ] 1 make square board
- [ ] 2 add mode human v human
- :heavy_check_mark: 3 в примерах с сортировками массивов заменить заранее предопределенные массивы на случайно генерируемые массивы чисел
(будет круто если будет метод генерации случайных массивов, которые будут использоваться везде)

