def tallEnough(height):
    heightCm=int(height)/0.39370
    if heightCm > 120 and heightCm < 190:
        return True
    else:
        return False

def whereIsWaldo(Int1,Int2):
    x=int (input("Guess Waldo's x-coordinate"))
    y=int (input("Guess Waldo's y-coordinate"))
    if x==Int1 and y==Int2:
        return "You found Waldo"
    else:
        return "Couldn't find Waldo. Better luck next time"

import string
def allLetters(userString):
    letters=string.ascii_letters
    aStr=""
    for c in userString:
        if c in letters:
           aStr+=c
    return aStr

def replaceLetter(aString, aLetter):
    newString=""
    letters=input("Please enter a letter")
    while letters not in aString:
          letters=input("Letter not in string. Input a letter")
    for x in range (len(aString)):
        if aString[x]==letters:
            newString= newString + aLetter
        else:
            newString=newString+aString[x]
    print(newString)

def countUp(start, end, increment):
    number=start
    while number in range(start,end+increment,increment):
          print(number)
          number=number+increment
    print("Done!")

def numMountainRange(X):
    rows=int(X)
    for num in range(1,rows+1):
        print(num*str(num)+(" "*2*(X-num))+num*str(num))

def printTimestable():
    aStr= ""
    aStr = aStr + "Times:" + "\t"
    for c in range (1,10):
        aStr = aStr + str(c) + "\t"
    print(aStr)
    for a in range (1,10):
        print(a, end= "\t")
        for b in range (1,10):
            print (a*b,end= "\t")
        print()

def printTimes(N):
    aStr= ""
    aStr= aStr + "Times:" + "\t"
    for c in range (1,N+1):
        aStr= aStr+ str(c) + "\t"
    print(aStr)
    for a in range (1,N+1):
        print(a,end= "\t")
        for b in range (1,N+1):
            print (a*b, end="\t")
        print()



