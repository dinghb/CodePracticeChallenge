'''
Description:
A string is considered to be in title case if each word in the string
is either (a) capitalised (that is, only the first letter of the word
is in upper case) or (b) considered to be an exception and put entirely
into lower case unless it is the first word, which is always capitalised.

Write a function that will convert a string into title case, given an
optional list of exceptions (minor words). The list of minor words will
be given as a string with each word separated by a space.
Your function should ignore the case of the minor words string -- it
should behave in the same way even if the case of the minor word string
is changed.

Example:
    title_case('a clash of KINGS', 'a an the of') # should return: 'A Clash of Kings'
    title_case('THE WIND IN THE WILLOWS', 'The In') # should return: 'The Wind in the Willows'
    title_case('the quick brown fox') # should return: 'The Quick Brown Fox'

'''


# Arguments:
#    title(required): the original string to be converted.
#    minor_words(optional): space-delimited list of minor words that
#            must always be lowercase except for the first word in the
#            string. The JavaScript/CoffeeScript tests will pass undefined
#            when this argument is unused.
def title_case(title, minor_words=''):
    if title == '':
        return ''

    if minor_words == '':
        # builtin title() method return a titlecased version of S, i.e. 'a bc c'.title() return 'A Bc D'
        return title.title()

    originlist = title.split(" ")
    minor_words_arr = [each_t.lower() for each_t in minor_words.split(" ")]
    titledarr = []
    for each_t in originlist:
        if len(titledarr) != 0 and each_t.lower() in minor_words_arr:
                titledarr.append(each_t.lower())
        else:
            titledarr.append(each_t.capitalize())

    return " ".join(titledarr)

print(title_case('a clash of KINGS', 'a an the of'))

