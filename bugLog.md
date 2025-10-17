## Bug 1
Brief description:  Buy method does not add the given computer to inventory, instead adds the same computer every time
Failed unit test: testBuy()

## Bug 2
Brief description:  Buy method does not throw intended Exception when a computer is bought twice
Failed unit test: testBuyException()

## Bug 3
Brief description:  Sell method does not throw intended Exception when a computer not in the inventory is sold
Failed unit test: testSellException()

## Bug 4
Brief description:  Computer constructor does not correctly set memory
Failed unit test: testComputerConstructor_Memory()

## Bug 5
Brief description:  Computer constructor does not correctly set price
Failed unit test: testComputerConstructor_Price()

## Bug 6
Brief description:  setOS method does not update the OS
Failed unit test: testSetOS()

## Bug 7
Brief description:  Computer toString method is not correctly formatted
Failed unit test: testComputerToString()

## Bug 8
Brief description:  refurbish does not correctly update price when the year is between 2000 and 2012
Failed unit test: testRefurbishOld()  ------- technically all except the new one failed, but that is only because of the buy() issue

## Bug 9
Brief description:  refurbish does not correctly update the OS
Failed unit test: testRefurbishNewOS()  ---------- technically the real issue is the setOS() method

## Bug 10
Brief description:  ResaleShop constructor adds a computer to inventory without being asked
Failed unit test: testResaleShopConstructor