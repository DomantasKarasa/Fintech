#compound interest https://www.analyticsvidhya.com/blog/2021/08/basic-financial-calculations-using-python/
def compound_interest(p,r,t):
    print('Amount: ', p)
    print("Rate of Interest (Per Annum)", r)
    print("Time (In Years): ",t)
    a= p*((1+r/100)**t)
    ci= a-p
    print("Final Amount: ", a)
    print("Compound Interest: ", ci)
    return "Amount: {p},Rate of Interest (Per Annum) {r},Time (In Years): {t},Final Amount: {a},Compound Interest: {ci}".format(p=p,r=r,t=t,a=a,ci=ci)
