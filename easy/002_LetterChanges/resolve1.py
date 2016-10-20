def LetterChanges(str):
    chararr = list(str)
    resultarr = []

    for char in chararr:
        asciicode = ord(char)
        if asciicode >= 97 and asciicode <= 122:
            if asciicode == ord("z"):
                converted_char = "a"
            else:
                converted_char = chr(asciicode + 1)

            if converted_char in "aeiou":
                converted_char = converted_char.upper()

            resultarr.append(converted_char)
        else:
            resultarr.append(char)

    return ''.join(resultarr)


# keep this function call here
print(LetterChanges(input()))