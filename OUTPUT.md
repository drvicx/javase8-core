# javase8-core
<hr/>


**=OUTPUTs:**

**ArrayListExample.class**
<pre>
=Java Collection.List.ArrayList EXAMPLES:


1 -- NON-GENERIC ArrayList:

[Dog, Cat, Racoon, Parrot]
4 elements
Dog
Cat
Racoon id is 2

[Dog, Cat, Racoon, Monkey]

[Dog, Cat, Racoon, Monkey, fakeAnimal1, fakeAnimal2, 77]
[Dog, Cat, Racoon, Monkey, fakeAnimal2, 77]

[Dog, Cat, Racoon, Monkey]


2 -- GENERIC ArrayList (List of AnimalObjects):

[Animal{Jessica,Cat}, Animal{Mila,Dog}, Animal{Bob,Racoon}, Animal{Jake,Parrot}]


3 -- ITERATE over ArrayList:

..Iterate over ArrayList using forEach loop:
Jessica
Mila
Bob
Jake

..Iterate over ArrayList using forEach loop & Lambda Expression:
Jessica
Mila
Bob
Jake

..Iterate over ArrayList using Iterator:
Cat
Dog
Racoon
Parrot

..Iterate over ArrayList using Iterator & Lambda Expression:
Cat
Dog
Racoon
Parrot


4 -- SORTING -- Get Pet Names List from Animal ArrayList an SORT:

..Before Sorting:
[Jessica, Mila, Bob, Jake]

..After Sorting:
[Bob, Jake, Jessica, Mila]

5 -- SERIALIZATION / DESERIALIZATION -- Save ArrayList Animal Data to file:

..process test data
Black
Withe
Yellow
Green

..process Animal Names data
Jessica
Mila
Bob
Jake

Process finished with exit code 0
</pre>
