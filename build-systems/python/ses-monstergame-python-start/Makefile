PYTHON = python3
SRCDIR = ./src
MAIN = $(SRCDIR)/main.py

.PHONY: run clean test install

# Run the Python program
run:
	$(PYTHON) $(MAIN)

# Clean up Python cache files
clean:
	find . -type d -name "__pycache__" -exec rm -rf {} +
	find . -type f -name "*.pyc" -delete
	find . -type f -name "*.pyo" -delete
	find . -type f -name "*.pyd" -delete

# Run tests if available
test:
	$(PYTHON) -m unittest discover -s tests

# Install dependencies from requirements.txt if it exists
install:
	[ -f requirements.txt ] && pip install -r requirements.txt || echo "No requirements.txt found"

# Default target
all: install run


