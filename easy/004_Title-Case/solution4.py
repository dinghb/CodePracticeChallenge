def title_case(title, minor_words=''):
    result = []
    for word in title.lower().split():
        if word not in minor_words.lower().split() or not result:
            result.append(word.capitalize())
        else:
            result.append(word.lower())

    return ' '.join(result)

print(title_case('a clash of KINGS', 'a an the of') == "A Clash of Kings")