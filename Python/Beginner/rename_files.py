import os
import string

def rename_files():
    # (1) get file names from a folder
    file_list = os.listdir(r"/Users/Fall/Dropbox/BCS/Python/Playground/prank")
    print(file_list)
    save_path = os.getcwd()
    print("Current working directory is"+save_path)
    os.chdir("/Users/Fall/Dropbox/BCS/Python/Playground/prank")
    # (2) for each file, rename filename
    trantab = str.maketrans('', '', "0123456789")
    for file_name in file_list:
        os.rename(file_name, file_name.translate(trantab))
    print('')
    file_list_after = os.listdir(r"/Users/Fall/Dropbox/BCS/Python/Playground/prank")
    print(file_list_after)
rename_files()
