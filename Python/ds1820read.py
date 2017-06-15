#!/usr/bin/python3
# -*- coding: utf-8 -*-

from subprocess import Popen, PIPE


def get_temperature():
	command = ["digitemp_DS9097", "-a", "-q", "-s" "/dev/ttyUSB0", "-c", "/home/maciek/Skrypty/digitemp.conf",
			   "-o", "\"%R;%.2C\""]
	cmd = Popen(command, stdout=PIPE, stderr=PIPE)
	cmd_out, cmd_err = cmd.communicate()
	if cmd_err == b'':
		return cmd_out
	else:
		return b'error'


if __name__ == "__main__":
	return_value = get_temperature(). \
		decode(encoding='UTF-8', errors='strict'). \
		replace("\"", "")
	output = return_value.rstrip("\n")
	print(output)
