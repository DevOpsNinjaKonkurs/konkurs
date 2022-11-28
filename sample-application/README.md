## Setup:
- instalacja **contour**
- stworzenie namespace **offer-calculator**
- instalacja **postgres**

```
cicd> setup
```

## Budowanie aplikacji:
- zbudowanie backend+frotend poprzez **maven**
- zbudowanie obrazów dockerowych backend+frontend

```
cicd> build
```

## Deployment aplikacji:
- załadowanie obrazów dockerowych do klastra **kind**
- usunięcie poprzednio zainstalownych obiektów
- instalacja charts

```
cicd> deployment
```

## Uruchomienie aplikacji
Wejście na adres **localhost** lub **localhost/credits**.

## Funkcjonalności aplikacji
1. wybieramy rodzaj kredytu
2. klikamy **wnioskuj**
3. otwiera się drugi ekran, wpisujemy tam dane personalne + wybieramy parametry
4. jeśli wszystko wypełnimy przycisk akceptacji po prawej stronie się aktywuje
5. klikamy przycisk akceptacji i wyświetli nam się raport kredytu na nowej karcie w pdf
   (lub pobierze na dysk, zależne od ustawień przeglądarki)

## Uwagi
- **kubectl delete** w procesie deployment jest po to, żeby po zmianie obrazów pojawiły się nowe wersje - na **kind**
nie mozna ustawić **ImagePullPolicy = Always**, stąd takie rozwiązanie
- **ingress** zajmuje sie routowaniem między frontend a backend poprzez prefix **/api**
- konfiguracja endpointu backendu po stronie frontendu znajduje się w plikach **offer-calculator-view/src/environments**