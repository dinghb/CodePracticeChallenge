import re


def title_case(title, minor_words=''):
    title = title.title()
    for word in minor_words.split():
        k = re.compile(r'\b' + word + r'\b', re.I)
        title = re.sub(k, word.lower(), title)

    return title[0:1].upper() + title[1:]

print(title_case('a clash of KINGS', 'a an the of') == "A Clash of Kings")