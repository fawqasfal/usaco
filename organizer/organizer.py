import os

for fn in os.listdir('.'):
	if os.path.isfile(fn):
		if os.path.isdir(os.path.splitext(fn)[0]):
			os.rename(fn, os.path.splitext(fn)[0] + '/' + fn)
