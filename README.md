# AISD - Algorytmy i Struktury Danych

##Lista 1
####Zadanie 1
Zaimplementuj w czystym C listę jednokierunkową z następującymi operacjami:

* *insert* – wstawiającą element do listy
* *delete* – usuwającą element z listy
* *isempty* – sprawdzającą czy lista jest pusta
* *findMTF* – sprawdzająca czy podany element jest na liście i w przypadku jego znalezienia przesuwający go na przód listy
* *findTRANS* – sprawdzająca czy podany element jest na liście i w przypadku jego znalezienia przesuwający go o jedno miejsce do przodu listy
Funkcje realizujące podane operacje nie mogą korzystać ze zmiennych globalnych, wszystkie dane powinny być przekazywane przez parametry. Jako wartości boolowskie przyjmujemy 0 jako fałsz a 1 jako prawdę. Sprawdź średnią liczbę porównań potrzebną na przeprowadzenie następującego scenariusza działań:
*wstaw w losowej kolejności elementy od 1 do 100 (100 elementów) na listę
*dopóki lista nie będzie pusta: sprawdź czy elementy od 1 do 100 są na liście a następnie usuń element maksymalny. Rozpatrz oba warianty operacji sprawdzającej. Która z nich daje mniejszą średnią liczbę porównań. Licznik porównań można zrealizować jako zmienną globalną.

##Lista 2
####Zadanie 1
Celem zadania jest zaimplementowanie i przetestowanie następującychalgorytmów sortowania:

* *SelectSort*
* *InsertionSort*
* *HeapSort*
* *QuickSort*

Program przyjmuje dwa parametry wejściowe --type select|insert|heap|quick – określający wykorzystywany algorytm sortowania oraz --asc|--desc – określający porządek sortowania. Wejściem dla programu są kolejno:

* liczba n – liczba elementów do posortowania
* ciąg elementów do posortowania (niech elementy tej listy zostaną nazwane kluczami)

####Zadanie 2

Uzupełnij program z Zadania 1 o możliwość wywołania go z parametrem uruchomienia --stat nazwa_pliku k, wtedy pomija on wczytywanie danych i dla każdego n ∈ {100, 200, 300, . . . , 10000} wykonuje po k niezależnych powtórzeń:

* generowania losowego ciągu n elementowego (zadbaj o dobry generator pseudolosowy)
* sortowania kopii wygenerowanego ciągu każdym algorytmem
* dla każdego z sortowań, zapisania do pliku nazwa_pliku statystyk odnośnie rozmiaru danych n, liczby wykonanych porównań między kluczami, liczby przestawień kluczy oraz czasu działania algorytmu sortującego
Po zakończeniu programu, korzystając z zebranych danych przedstaw na wykresach.

#### Zadanie 3
Dodaj do poprzednich zadań modyfikację algorytmu QuickSort (ModyfiedQuickSort, opcja --type mquick), która wykonuje następujące czynności:

* jeśli zostało co najwyżej 16 elementów to QuickSort zastąp przez InsertionSort
* wybiera element dzielący jako medianę pierwszego, środkowego i ostatniego elementu (pamiętaj o porównaniach między tymi elementami)
