# EltexSchool
## Задания выполняемые в летней школе Eltex.

---------------------------------------------------------------------
### 1. Основы программирования на Java. Создание простейших приложений.
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ:
1. Разработать простое консольное приложение. 
2. Сформировать иерархии классов и интерфейсов, сделать реализацию методов. 
3. Сделать начальный ввод данных при запуске приложения через параметры командной строки:
	количество вводимых объектов;
	вид представления. 

4. После запуска приложения с клавиатуры вводятся данные объекта и выводятся на консоль.
5. При запуске приложения в зависимости от вида представления создается класс потомка.
6. Объекты реализуются через наследование: интерфейс → абстрактный класс → наследники.
Создать интерфейс *ICrudAction*, задающий действия над объектом (*create*, *read*, *update*, *delete*):
  - *create* – заполнение объекта случайными значениями и инкремент счётчика.
  - *read* – вывод данных на экран.
  - *update* – ввод данных с клавиатуры.
  - *delete* – принудительное зануление данных в объекте и декремент счетчика.
Создать иерархию классов, определяющих объекты по варианту и реализующих интерфейс IcrudAction.

7. Сделать счётчик объектов в базовом абстрактном классе.
8. Сделать ID объекта в базовом абстрактном классе. 
ID инициализируется в конструкторе объекта. Используйте класс UUID. 
9. Сделать перегрузку конструкторов в классах-наследниках.

> Класс для тестирования находится: ru.eltex.app.java.model.test.lab1.Main

##### Вариант базы данных:

Список объектов продажи элетроники 3-х видов: телефоны, сматфоны и планшеты.

 Поля базового класса: | 
------------ | 
ID товара | 
 Цена |
 Счётчик товаров |
 Фирма |
 Модель |
 ОС |

Поля для телефонов: | Поля для сматфонов: | Поля для планшетов: | 
------------ | ------------ | ------------ | 
 Тип корпуса (*классический*, *раскладушка*) |  Тип SIM-карты (*micro-SIM*, *обычная*) | Видеопроцессор | 
.............................................| Количество SIM-карт |  Разрешение экрана |


> Класс для тестирования находится: ru.eltex.app.java.model.test.lab1.Main
---------------------------------------------------------------------
### 2. Классы-коллекции.
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ:
1. Изучить особенности реализации классов-коллекций в Java.
2. Доработать программу, разработанную ранее.
3. Разработать класс для хранения и обработки персональных данных пользователей  Credentials (Поля: *ID*, *Фамилия*, *Имя*, *Отчество*, *e-mail*).
4. Разработать класс-коллекцию «корзину» (*ShoppingCart*) для сгенерированных объектов по варианту. 
При операции *add* происходит добавление объекта в «корзину». 
При операции *delеte* происходит удаление объекта из «корзины».
5. Разработать класс «заказ» (*Order*).  
6. Добавить для класса «заказ» поле «статус заказа» (в ожидании , обработан). 
7. Добавить для класса «заказ» поля «время создания» и «время ожидания».
Время создания устанавливается в момент оформления покупки.
Время ожидания – время, через которое заказ должен исчезнуть (должен быть обработан), считая от времени создания.  
8. Разработать класс-коллекцию «заказы» (*Orders*)  для объединения списка заказов. 
9. Для класса «заказы» разработайте функцию «оформить покупку». 
При выполнении данной функции «корзина» с товарами объединяется в объект «заказ» вместе с данными пользователя и добавляется в класс-коллекцию «заказы».
Реализовать отношение - агрегация. Агрегация (агрегирование по ссылке) — отношение «часть-целое» между двумя равноправными объектами,
когда один объект (контейнер) имеет ссылку на другой объект.
10. Добавить функцию проверки заказов - обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан».
11. Для хранения сгенерированных идентификаторов товаров используйте коллекцию, удобную для поиска в соответствии с вашим вариантом.
12. Добавьте функцию поиска объекта в коллекции «корзина» по идентификатору.
13. Добавьте в класс-коллекцию «корзина» функцию «показать все объекты».
14. Добавьте в класс-коллекцию «заказы» функцию «показать все заказы».
15. Продемонстрировать в программе все новые функции.

##### Вариант задания:
- Коллекция для хранения объектов в классе «корзина»: *ArrayList*
- Коллекция для хранения объектов в классе «заказы»: *LinkedList*
- Коллекция для хранения и поиска уникальных идентификаторов: *HashSet*
- Коллекция для хранения объектов по времени создания: *HashMap*

> Класс для тестирования находится: ru.eltex.app.java.model.test.lab23.Main
---------------------------------------------------------------------
### 3. Generic-классы в Java.
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ:
1. Изучить принципы построения классов и методов generic в Java.
2. Доработать программу, разработанную ранее.
3. Сделать из класса «корзина» Generic-класс, позволяющий работать с объектами (*добавлять*, *удалять* и т.д.). 
В качестве параметра класс должен принимать различные объекты (использовать ограничения на тип).
4. Сделать из класса «заказы» Generic-класс, позволяющий работать с заказами (*добавлять*, *удалять* и т.д.). 
5. Протестируйте на коллекциях разных видов и посмотрите за ошибками компиляции, которые возникают при неправильном использовании *generics*.


---------------------------------------------------------------------
### 4. Многопотоковые приложения.
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ:
1. Изучить особенности реализации и работы потоков в Java.
2. Доработать программу, разработанную ранее.
3. Создать абстрактный класс *ACheck*, описывающий проверку заказов по статусу.
4. Реализовать класс *ACheck* для каждого статуса заказа. Оба класса должны быть выполнены в виде отдельных потоков и работать с коллекцией объектов.
Один поток с определенным интервалом или по команде с консоли делает проверку коллекции и проверяет заказы по статусу «в ожидании». 
Если заказ обнаружен в этом состоянии, то меняется статус заказа на состояние «обработан».
Другой поток проверяет заказы по статусу «обработан». 
Если заказ обнаружен в этом состоянии, заказ удаляется из списка. 
5. Сделать класс автоматической генерации заказов в виде отдельного потока.
Спроектируйте класс таким образом, чтобы можно было запустить одновременно несколько экземпляров класса с разным интервалом времени.
6. Продемонстрировать работу классов-потоков.

> Класс для тестирования находится: ru.eltex.app.java.model.test.lab4.Main
---------------------------------------------------------------------
### 5. Потоки данных. Работа с локальными файлами.
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ:
1. Изучить особенности реализации потоков ввода-вывода в Java.
2. Доработать программу, разработанную ранее.
3. Разработать интерфейс *IOrder* (*readById*, *saveById*, *readAll*, *saveAll*) и абстрактный базовый класс AManageOrder для хранения заказов.
4. Реализовать класс  *ManagerOrderFile* для хранения заказов в виде двоичного файла.
5. Реализовать класс  *ManagerOrderJSON* для хранения заказов в виде текстового файла в формате JSON.

> Класс для тестирования находится: ru.eltex.app.java.model.test.lab5.Main
---------------------------------------------------------------------
### 6. Сетевые приложения «клиент-сервер».
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ:
1. Изучить особенности реализации сетевых приложений в Java.
2. Используя программу, разработанную ранее, разработать клиент-серверное приложение.
3. Сервер по UDP делает оповещение в локальную сеть, высылая внутри пакета порт на соединение.
4. Клиент слушает UDP-порт и ждет оповещения.
Получив оповещение, клиент извлекает порт и *IP* сервера из пакета и устанавливает соединение по TCP.
Оправляет заказ. Отсоединяется от сервера. 
Ждет оповещения о статусе заказа по *UDP* и генерирует новые заказы при условии получения оповещения.
5. Сервер, получив заказ, складывает его в очередь заказов.
6. Организовать на сервере автоматическую обработку заказов, используя наработки из предыдущих лабораторных работ. 
При изменении на статус «обработан» клиенту по *UDP* высылается оповещение.  
7. Клиент, получив оповещение о изменении статуса заказа, выводит на консоль время обработки заказа и информацию о заказе.
8. Сделать возможность одновременной работы нескольких клиентов. 
Оповещения можно делать на несколько *UDP* портов. 

> Класс для тестирования находится: ru.eltex.app.java.model.test.lab6.Main
---------------------------------------------------------------------
### 7. Java EE. Spring Framework.
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ: 
1. Используя Spring Boot, разработать простое MVC веб-приложение.
2. Для сборки проекта использовать сборщик maven.
3. Для логирования операций использовать *Log4j*.
4. Сделать обработку команды (readAll).
При запросе в строке браузера http://localhost:[port]/?command=readall
возвращаются все заказы в виде JSON.
5. Сделать обработку команды (readById).
При запросе в строке браузера http://localhost:[port]/?command=readById&order_id=[id]
возвращается обратно заказ с идентификатором [id] в виде JSON.
6. Сделать обработку команды (addToCard).
При запросе в строке браузера http://localhost:[port]/?command=addToCard&card_id=[id]
генерируется товар и добавляется в корзину с идентификатором [id].
Пользователю возвращается id нового товара.
7. Сделать обработку команды (delById).
При запросе в строке браузера http://localhost:[port]/?command=delById&order_id=[id]
удаляется заказ с идентификатором [id].
Пользователю возвращается 0 в случае успешного удаления и >1 если была ошибка.
8. Написать свой класс-обработчик ошибок при удалении.
(код 1 - нет такого заказа, код 2 - файл поврежден, 3 - неправильная команда).

> Класс для тестирования находится: ru.eltex.app.java.controller.OrdersControllerHakedMVC
---------------------------------------------------------------------
### 8. Java EE. Hibernate Framework.
---------------------------------------------------------------------
#### ОСНОВНЫЕ ЗАДАЧИ:
1. Изучить Hibernate Framework.
2. Установить БД mysql.
3. Создать таблицы в БД согласно своему варианту.
4. Реализовать команды из предыдущей лабораторной работы, используя Hibernate Framework 
5. Настройки к БД хранить в Properties File проекта.
6. Для сборки проекта использовать сборщик gradle.


> Класс для тестирования находится: ru.eltex.app.java.controller.OrdersControllerHibernate
---------------------------------------------------------------------
