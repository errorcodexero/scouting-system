import numpy as np

def get_opr(team_matrix, results_matrix):

    opr_final = np.matrix()
    team_inv = team_matrix.inv()

    opr_final = results_matrix * team_inv


    return opr_final
