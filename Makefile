build: checkstyle test
	make -C app build
run-dist:
	make -C app run-dist
checkstyle:
	make -C app checkstyle
test:
	make -C app test