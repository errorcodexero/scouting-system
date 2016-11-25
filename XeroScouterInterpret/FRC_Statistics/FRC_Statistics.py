import numpy as np

def get_opr(team_matrix, results_matrix):
    results = np.linalg.lstsq(team_matrix, results_matrix)
    return results

def get_dpr(team_matrix, results):

    result_size = len(results)

    results = np.reshape(results, (int((result_size/2)), 2))
    results = np.fliplr(results)
    results = results.reshape(result_size, -1)

    dpr = np.linalg.lstsq(team_matrix, results)

    return dpr

'''results_matrix = np.array([61, 39, 62, 100, 86, 60, 74, 51, 66, 44, 52, 32, 65, 31, 45, 62, 72, 79, 41, 82, 36, 74, 75, 58, 27, 64, 77, 55, 70, 49, 30, 84, 97, 96, 11, 117, 51, 24, 23, 34,
82, 41, 101, 13, 59, 55, 89, 125, 37, 67, 114, 27, 61, 56, 59, 44, 76, 42, 56, 51, 70, 8, 38, 126, 64, 68, 93, 38, 36, 89, 87, 53, 59, 46, 47, 62, 52, 64, 85, 104, 64, 43, 48, 57, 27, 84,
54, 67, 61, 62, 53, 56, 108, 57, 81, 61, 61, 78, 54, 74, 63, 53, 62, 33, 35, 94, 62, 99, 55, 31, 59, 43, 84, 77, 55, 59, 45, 46, 57, 60, 53, 38, 11, 60, 78, 79, 85, 65, 51, 60, 75, 57, 51,
64, 33, 60, 46, 98, 104, 65, 81, 38, 53, 65])

#results_matrix = np.genfromtxt(fname='./results.data', delimiter=',', skip_header=1)

team_matrix = np.genfromtxt(fname='./team_data.data', delimiter=',')
results = np.array([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])


opr_results = np.array([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
dpr_results = np.array([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])

opr_results = get_opr(team_matrix, results_matrix)

dpr_results = get_dpr(team_matrix, results_matrix)

print(opr_results)
print(dpr_results)'''
