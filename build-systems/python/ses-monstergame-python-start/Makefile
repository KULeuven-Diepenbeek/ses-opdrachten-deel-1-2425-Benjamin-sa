PYTHON = python3
MAIN = app.py

.PHONY: run clean test install

run:
	$(PYTHON) $(MAIN)

clean:
	find . -type d -name "__pycache__" -exec rm -rf {} +
	find . -type f -name "*.pyc" -delete
	find . -type f -name "*.pyo" -delete
	find . -type f -name "*.pyd" -delete

test:
	$(PYTHON) -m unittest discover -s tests

install:
	[ -f requirements.txt ] && pip install -r requirements.txt || echo "No requirements.txt found"

all: install run


