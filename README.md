# Генератор парсеров для LALR(1) грамматик
Входная грамматика имеет вид схожий с грамматиками для antlr, c расширением .g4. Грамматика грамматик описана в файле [GrammarForGrammars.g4](src/main/antlr4/GrammarForGrammars.g4)  
Для данного файла генерируются лексер и парсер в папку [my](target/generated-sources/my)  
Поддерживаются синтезируемые атрибуты, есть возможность задать правила "вычисления" распаршенного текста для файла
Запускается из файла [basedir](src/main/ru/ifmo/rain/balahnin/basedir.kt)
### Тесты
* парсер для грамматики  арифмитических выражени, вычисления с ними [calculator](src/test/ru/ifmo/rain/balahnin/calculator)
* парсер логических выражний [logic](src/test/ru/ifmo/rain/balahnin/logic_in_c)