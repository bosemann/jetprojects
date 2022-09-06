import random
dict_ = {}
zero = 0
friends = int(input("Enter the number of friends joining (including you)\n"))
print("")
if friends <= 0:
    print("No one is joining for the party\n")
    quit()

print("Enter the name of every friend (including you), each on a new line:")
for _ in range(friends):
    key = input()
    dict_[key] = 0
print("")
total_bill = int(input("Enter the total bill value:\n"))
print("")
share_amt = round((total_bill / friends), 2)
bill_for_friends = {key: share_amt for key in dict_}

answer = input('Do you want to use the "who is lucky?" feature? write Yes/No:\n')
if answer.lower() != 'yes':
    print("No one is going to be lucky")
    print("")
    print(bill_for_friends)

else:
     keys_list = list(dict_.keys())
     name = random.choice(keys_list)
     print(f'{name} is the lucky one!')
     print("")

     # resplit the bill
     new_share = round((total_bill/(friends - 1)), 2)
     value = new_share
     updated_bill = dict_.fromkeys(bill_for_friends, value)
     updated_bill[name] = 0
     print(updated_bill)



# print(bill_for_friends)
