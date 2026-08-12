# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Clojure learning repository containing daily coding exercises (day1.clj through day17.clj) designed for a 30-day Clojure learning journey. Each file contains a specific programming challenge with implementation and testing code.

## Development Commands

### Running Clojure Code
- `clojure -M file.clj` - Run a specific Clojure file
- `clojure -M -r` - Start an interactive REPL
- `clojure -M:nrepl` - Start nREPL server for editor integration

### Testing Code
Tests are embedded within each daily exercise file using the `comment` blocks and `tester` functions. To test a specific day's solution:
1. Load the file in a REPL session
2. Evaluate the test expressions in the `comment` blocks
3. The `tester` function compares expected vs actual results

Example testing pattern used throughout:
```clojure
(defn tester [arg exp]
  (= (function-name arg) exp))

(comment
  (tester input expected-output))
```

## Code Architecture

### File Structure
- `dayN.clj` - Daily programming exercises with implementations and tests
- `deps.edn` - Clojure CLI configuration with nREPL alias
- `mallil.clj` - Example schema definition using maps and keywords
- `test_sample.clj` - Simple function testing template
- `.clj-kondo/` - Static analysis cache directory
- `.cpcache/` - Clojure CLI dependency cache
- `.lsp/` - Language server cache

### Common Patterns
- Each daily exercise follows the pattern: problem description → implementation → testing function → test cases in comments
- Functions are typically pure and focus on algorithmic problem-solving
- Test cases use the `tester` helper function for consistent testing approach
- Comments include detailed explanations and example walkthroughs

### Dependencies
- Uses Clojure CLI (deps.edn) rather than Leiningen
- Minimal external dependencies - primarily uses Clojure core library
- nREPL configured for development tooling integration

## Development Workflow

1. Open individual day files to work on specific exercises
2. Use REPL-driven development by evaluating code incrementally
3. Test implementations using the comment blocks and tester functions
4. Most exercises are self-contained within their respective files